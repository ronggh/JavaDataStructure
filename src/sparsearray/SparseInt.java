package sparsearray;

/**
 * 稀疏数组
 */
public class SparseInt {
    private int sparseArray[][];

    // 构造方法：从原始二维数组构造一个稀疏数组
    public SparseInt(int array[][]) {
        // 1. 遍历二维数组，得到非0元素个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2. 创建稀疏数组
        sparseArray = new int[sum + 1][3];
        // 给稀疏数组赋值，第一行：行数，列数，非0元素数
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 其它行：行号，列号，元素值
        int index = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = array[i][j];
                    index++;
                }
            }

        }
    }

    // 输出稀疏数组
    public void print(){
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
    }

    // 将稀疏数组转换为普通二维数组
    public int[][] toArray(){
        // 将稀疏数组恢复为原始二维数组
        int array[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 遍历稀疏数组，恢复值
        for(int i = 1; i<sparseArray.length;i++){
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int val = sparseArray[i][2];

            array[row][col] = val;
        }
        return array;
    }

    // 测试
    public static void main(String[] args) {
        // 创建一个原始的二维数组，11*11
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 6;

        SparseInt spareInt = new SparseInt(chessArray);
        spareInt.print();

        int array[][] = spareInt.toArray();
        for (int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
