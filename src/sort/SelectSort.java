package sort;

import java.util.Arrays;

/**
 * 每轮从剩余的数据中选一个最小的，与对应位置数据进行交换
 * 交换次数少，比冒泡速度快
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前：" + Arrays.toString(array));
        SelectSort ss = new SelectSort();
        ss.selectSort(array);

        // 时间复杂度：O(n^2),测试一下排序速度
        int array3[] = new int[80000];
        for(int i = 0; i< array3.length;i++){
            array3[i] = (int)(Math.random() * 1000000);
        }
        System.out.println("排序前：" + Arrays.toString(array3));

        long startTime = System.currentTimeMillis();
        ss.selectSort(array3);
        long endTime =  System.currentTimeMillis();
        System.out.println("耗时："+ (endTime-startTime) +"毫秒");

    }

    public void selectSort(int[] array) {

        for (int index = 0; index < array.length - 1; index++) {
            // 本轮最小值索引的位置
            int minIndex = index;
            // 先默认最小值为当前的索引位置
            int minValue = array[minIndex];

            // 与剩余数据比较，选一个最小的数，进行交换
            for (int j = index + 1; j < array.length; j++) {
                if (minValue > array[j]) {
                    // 找到最小值
                    minValue = array[j];
                    // 记录最小值的位置索引
                    minIndex = j;
                }
            }

            // 判读是否需要交换
            if(minIndex != index) {
                // 交换：现索引值位置的值放在最小值索引的位置
                array[minIndex] = array[index];
                // 最小值放在应在的索引位置
                array[index] = minValue;
            }

            //System.out.printf("第%d轮排序结果：%s\n",(index+1),Arrays.toString(array));
        }
    }
}
