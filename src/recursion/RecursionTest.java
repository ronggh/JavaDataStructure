package recursion;

public class RecursionTest {
    public static void main(String[] args) {
        //
        test1(5);
        System.out.println("加入Else后：");
        test2(5);
        System.out.println("阶乘："+factorial(5));
    }

    public static void test1(int n) {
        if (n > 2) {
            test1(n - 1);
        }
        System.out.println("n=" + n);
    }

    public static void test2(int n) {
        if (n > 2) {
            test2(n - 1);
        } else {
            System.out.println("n=" + n);
        }
    }

    // 阶乘问题
    public static int factorial(int n){
        if(n == 1) return 1;
        else{
            return factorial(n-1)*n;
        }
    }
}
