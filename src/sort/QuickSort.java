package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-9,78,0,23,-567,70};

        QuickSort qs = new QuickSort();

        // 测试正确性
        qs.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

        // 测试速度
        int array3[] = new int[800000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (int) (Math.random() * 10000000);
        }
        //System.out.println("排序前：" + Arrays.toString(array3));

        long startTime = System.currentTimeMillis();
        qs.quickSort(array3);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");


    }

    public void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }

    /**
     * Quick Sort
     * @param array
     * @param left
     * @param right
     */
    public void quickSort(int []array,int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = array[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while( l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while( array[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while(array[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }

            //交换
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(array[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(array[r] == pivot) {
                l += 1;
            }
        }


        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(array, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(array, l, right);
        }


    }
}
