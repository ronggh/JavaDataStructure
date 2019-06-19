package sparsearray;


public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组，11*11
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 6;
        // 输出原始二维数组
        System.out.println("原始的二维数组：");
        for (int[] row : chessArray) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将二维数组转为稀疏数组
        // 1. 遍历二维数组，得到非0元素个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        //
        System.out.println("非0元素个数：" + sum);
        // 2. 创建稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        // 给稀疏数组赋值，第一行：行数，列数，非0元素数
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 其它行：行号，列号，元素值
        int index = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArray[i][j];
                    index++;
                }
            }

        }

        // 输出稀疏数组
        System.out.println("得到的稀疏数组：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        // 将稀疏数组恢复为原始二维数组
        int chess[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 遍历稀疏数组，恢复值
        for(int i = 1; i<sparseArray.length;i++){
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int val = sparseArray[i][2];

            chess[row][col] = val;
        }

        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int[] row : chess) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }


    }
}
