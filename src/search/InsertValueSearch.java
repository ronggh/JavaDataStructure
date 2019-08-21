package search;

/**
 * 插值查找是对二分查找的优化，区别在于
 * mid = left + (right - left) * (findValue - array[left]) / (array[right] - array[left])
 * 对于分布值均匀查找速度快
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int [] array1 = new int[100];
		for(int i = 0; i < 100; i++) {
			array1[i] = i + 1;
		}

        InsertValueSearch ivs = new InsertValueSearch();

        int index = ivs.insertValueSearch(array1, 0, array1.length-1, 1);
        System.out.println("index = " + index);


    }



    /**
     *说明：插值查找算法，也要求数组是有序的
     * @param array 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findValue 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public  int insertValueSearch(int[] array, int left, int right, int findValue) {

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findValue < array[0] || findValue > array[array.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]) ;
        //System.out.println("mid = " + mid);
        int midVal = array[mid];
        if (findValue > midVal) { // 说明应该向右边递归
            return insertValueSearch(array, mid + 1, right, findValue);
        } else if (findValue < midVal) { // 说明向左递归查找
            return insertValueSearch(array, left, mid - 1, findValue);
        } else {
            return mid;
        }

    }
}
