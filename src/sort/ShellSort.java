package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {101, 34, 119, 1, -1, 89};
        System.out.println("排序前：" + Arrays.toString(array));

        ShellSort ss = new ShellSort();
        ss.shellSort(array);

        System.out.println("排序后：" + Arrays.toString(array));

        int array2[] = new int[80000];
        int array3[] = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array2[i] = (int) (Math.random() * 1000000);
            array3[i] = array2[i];
        }
        System.out.println("排序前：" + Arrays.toString(array3));

        long startTime = System.currentTimeMillis();
        ss.shellSort(array2);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        //System.out.println("排序后：" + Arrays.toString(array3));

        //
        System.out.println("优化后：");
        startTime = System.currentTimeMillis();
        ss.shellSort2(array3);
        endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        //System.out.println("排序后：" + Arrays.toString(array3));


    }

    // 希尔排序之交换法，效率较低
    public void shellSort(int []array){
        int temp = 0;
        int count = 0;

        //分组
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(array));

        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] array) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        //移动
                        array[j] = array[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    array[j] = temp;
                }

            }
        }
    }
}
