package search;

import java.util.ArrayList;
import java.util.List;

//注意：使用二分查找的前提是 该数组是有序的.
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        //
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int resIndex = bs.binarySearch(arr, 0, arr.length - 1, 1000);
		System.out.println("resIndex = " + resIndex);

		//
        int array3[] = { 1, 8, 10, 89,1000,1000, 1234 };
        List<Integer> resIndexList = bs.binarySearch2(array3, 0, arr.length - 1, 1000);
        System.out.println("resIndexList = " + resIndexList);

    }

    /**
     * 二分查找算法
     * @param array
     *            数组
     * @param left
     *            左边的索引
     * @param right
     *            右边的索引
     * @param findValue
     *            要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public int binarySearch(int[] array, int left, int right, int findValue) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        //
        int mid = (left + right) / 2;
        int midVal = array[mid];

        if (findValue > midVal) { // 向 右递归
            return binarySearch(array, mid + 1, right, findValue);
        } else if (findValue < midVal) { // 向左递归
            return binarySearch(array, left, mid - 1, findValue);
        } else {

            return mid;
        }

    }

    /*
     * 思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     *
     * 思路分析
     * 1. 在找到mid 索引值，不要马上返回
     * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 4. 将Arraylist返回
     */

    public List<Integer> binarySearch2(int[] array, int left, int right, int findValue) {

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = array[mid];

        if (findValue > midVal) { // 向 右递归
            return binarySearch2(array, mid + 1, right, findValue);
        } else if (findValue < midVal) { // 向左递归
            return binarySearch2(array, left, mid - 1, findValue);
        } else {
            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while(true) {
                if (temp < 0 || array[temp] != findValue) {//退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp --; //temp左移
            }

            // 将mid加进来
            resIndexlist.add(mid);  //

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while(true) {
                if (temp > array.length - 1 || array[temp] != findValue) {//退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp ++; //temp右移
            }

            return resIndexlist;
        }

    }
}
