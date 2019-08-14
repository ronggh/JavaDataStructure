package stack;

public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }

        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("第%d个：%d\n", i, stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.show();
        System.out.println("弹出栈顶：" + stack.pop());
        stack.show();
    }
}
