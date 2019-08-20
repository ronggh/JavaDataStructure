package sort;

import java.util.Arrays;

/**
 * 相邻数据两两比较，每一轮最大的一个数会被排到应在的位置
 */
public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {3, 9, -1, 10, -2};
        int array2[] = {3, 9, -1, 10, 20};

        System.out.println("排序前：" + Arrays.toString(array));
        BubbleSort bubble = new BubbleSort();
        bubble.bubbleSort(array);

        System.out.println("优化算法：");
        System.out.println("排序前：" + Arrays.toString(array2));
        bubble.bubbleSort2(array2);

        // 时间复杂度：O(n^2),测试一下排序速度
        int array3[] = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (int) (Math.random() * 1000000);
        }
        System.out.println("排序前：" + Arrays.toString(array3));

        long startTime = System.currentTimeMillis();
        bubble.bubbleSort2(array3);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");

        System.out.println("排序后：" + Arrays.toString(array3));


    }

    public void bubbleSort(int[] array) {
        // 排序趟数：数组个数-1
        // 变量定义在循环外
        int temp = 0;
        for (int index = 0; index < array.length - 1; index++) {
            // 第index趟排序
            for (int i = 0; i < array.length - (index + 1); i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

            //System.out.printf("第%d趟排序后：%s\n", (index+1), Arrays.toString(array));
        }
    }

    /**
     * 优化
     *
     * @param array
     */
    public void bubbleSort2(int[] array) {
        // 排序趟数：数组个数-1
        // 排序趟数：数组个数-1
        for (int index = 0; index < array.length - 1; index++) {
            // 优化：如果某趟排序过程中未发生交换，则已经是有序的了。
            boolean flag = false; // 标志，如果发生了交换，则置为true.
            // 第index趟排序
            for (int i = 0; i < array.length - (index + 1); i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }

            // System.out.printf("第%d趟排序后：%s\n", (index + 1), Arrays.toString(array));
            if (!flag) {
                break;
            }

        }
    }


}
