package queue;

import java.util.Scanner;

/**
 * 用数组来实现队列
 * 问题：空间不能重复利用
 */
public class ArrayQueue {
    //
    private int maxSize;
    private int head;
    private int tail;
    private int[] array;

    // 构造方法
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.head = -1;
        this.tail = -1;
    }

    // 判断队列是否满
    public boolean isFull() {
        return this.tail == this.maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    // 添加数据到队列
    public boolean addQueue(int data) {
        // 先判断队列是否已满
        if (isFull()) return false;

        //
        this.tail++;
        this.array[tail] = data;
        return true;
    }

    // 数据出队列
    public int getQueue() {
        // 先判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列已为空");
        }

        head++;
        return this.array[head];
    }

    // 显示队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = 0; i < this.array.length; i++) {
            System.out.printf("array[%d] = %d\n", i, this.array[i]);
        }

    }

    // 显示队列的头元素，并不取出
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return this.array[this.head+1];
    }


    // 测试
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key =' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            //
            System.out.println("s(Show)：显示队列");
            System.out.println("a(Add)：添加一个数到队列");
            System.out.println("g(Get)：从队列中取出一个数");
            System.out.println("h(Head)：显示队列头元素");
            System.out.println("x(eXit)：退出程序\n");

            //
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                     queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int val = scanner.nextInt();
                    boolean successed =queue.addQueue(val);
                    if(!successed){
                        System.out.println("队列已满");
                    }
                    break;
                case 'g':
                    try{
                        int result = queue.getQueue();
                        System.out.println("取出的数是："+result);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int result = queue.headQueue();
                        System.out.println("队列的头元素是："+result);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'x':
                    loop = false;
                    scanner.close();
                    break;
            }
        }

        System.out.println("程序退出...");
    }
}
