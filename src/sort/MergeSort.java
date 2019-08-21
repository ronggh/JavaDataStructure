package sort;

import java.util.Arrays;

public class MergeSort {
    //
    public static void main(String[] args) {
        // 测试正确性
        int array[] = { 8, 4, 5, 7, 1, 3, 6, 2 };

        MergeSort ms = new MergeSort();
        ms.mergeSort(array);
        System.out.println("排序后：" + Arrays.toString(array));

        // 测试速度
        // 测试速度
        int array3[] = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (int) (Math.random() * 1000000);
        }
        //System.out.println("排序前：" + Arrays.toString(array3));

        long startTime = System.currentTimeMillis();
        ms.mergeSort(array3);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");

    }

    public void mergeSort(int[] array){
        mergeSort(array,0,array.length-1);
    }

    //分+合方法
    public  void mergeSort(int[] arr, int left, int right) {

        if(left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right);
            //合并
            merge(arr, left, mid, right);

        }
    }

    /**
     *合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length]; //temp 做中转的数组
        int i = left; // 初始化i, 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int index = 0; // 指向temp数组的当前索引

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 index++, i++
            if(arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
                /*
                temp[index] = arr[i];
                index += 1;
                i += 1;
                */
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[index++] = arr[j++];
                /*
                temp[index] = arr[j];
                index += 1;
                j += 1;
                */
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[index++] = arr[i++];
            /*
            temp[index] = arr[i];
            index += 1;
            i += 1;
            */
        }

        while( j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[index++] = arr[j++];
            /*
            temp[index] = arr[j];
            index += 1;
            j += 1;
            */
        }


        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        index = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= right) {
            arr[tempLeft] = temp[index];
            index += 1;
            tempLeft += 1;
        }

    }
}
