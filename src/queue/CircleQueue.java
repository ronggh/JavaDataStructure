package queue;

import java.util.Scanner;

/**
 * 用数组来实现队列
 * 用环形，取模实现空间的复用
 */
public class CircleQueue {
    //
    private int maxSize;
    private int head;
    private int tail;
    private int[] array;

    // 构造方法
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        //
        this.array = new int[maxSize];
        this.head = 0;
        this.tail = 0;
    }

    // 判断队列是否满
    public boolean isFull() {

        return (this.tail + 1) % this.maxSize == this.head;
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
        this.array[tail] = data;
        this.tail = (this.tail + 1) % this.maxSize;

        return true;
    }

    // 数据出队列
    public int getQueue() {
        // 先判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列已为空");
        }

        //
        int value = this.array[head];
        this.head = (this.head + 1) % this.maxSize;
        return value;
    }

    // 显示队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = this.head; i < this.head + size(); i++) {
            System.out.printf("array[%d] = %d\n", i % this.maxSize, this.array[i % this.maxSize]);
        }

    }

    // 队列中的有效元素个数
    public int size() {
        return (this.tail + this.maxSize - this.head) % this.maxSize;
    }

    // 显示队列的头元素，并不取出
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        return this.array[this.head];
    }


    // 测试
    public static void main(String[] args) {

        // 多定义一个空间，作为下一个的指向,实际容量为3个
        CircleQueue queue = new CircleQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            //
            System.out.println("s(Show)：显示队列");
            System.out.println("a(Add)：添加一个数到队列");
            System.out.println("g(Get)：从队列中取出一个数");
            System.out.println("h(Head)：显示队列头元素");
            System.out.println("x(eXit)：退出程序\n");

            //
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int val = scanner.nextInt();
                    boolean successed = queue.addQueue(val);
                    if (!successed) {
                        System.out.println("队列已满");
                    }
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.println("取出的数是：" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.println("队列的头元素是：" + result);
                    } catch (Exception e) {
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
