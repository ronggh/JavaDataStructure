package search;

public class SeqSearch {
    public static void main(String[] args) {
        int array[] = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组
        SeqSearch ss = new SeqSearch();
        int index = ss.seqSearch(array, 11);
        if(index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为 = " + index);
        }

    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * @param array
     * @param value
     * @return
     */
    public int seqSearch(int[] array, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
