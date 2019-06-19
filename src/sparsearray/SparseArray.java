package sparsearray;


public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组，11*11
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        // 输出原始二维数组
        System.out.println("原始的二维数组：");
        for(int[] row:chessArray){
            for (int item:row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        // 将二维数组转为稀疏数组


    }
}
