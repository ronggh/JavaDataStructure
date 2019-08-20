package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {101, 34, 119, 1, -1, 89};

        System.out.println("排序前：" + Arrays.toString(array));

        InsertSort is = new InsertSort();
        is.insertSort(array);

        System.out.println("排序后：" + Arrays.toString(array));

        int array3[] = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (int) (Math.random() * 1000000);
        }
        System.out.println("排序前：" + Arrays.toString(array3));

        long startTime = System.currentTimeMillis();
        is.insertSort(array3);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        System.out.println("排序后：" + Arrays.toString(array3));

    }

    public void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];// 待插入的数据值
            int insertIndex = i - 1;  // 待插入数据的前一个位置索引

            // 为待插入的数据值找到合适的位置
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                // 后移一个位置
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--; // 指针前移
            }

            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }

//            System.out.println("第"+i+"轮插入");
//            System.out.println(Arrays.toString(array));
        }
    }
}
