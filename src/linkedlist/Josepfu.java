package linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        csll.create(5);
        csll.show();
        // 出列
        csll.pop(1, 2, 5);

        // 用数组来实现
        arrayPop(1,2,5);
    }

    /**
     * @param startNo
     * @param countNum
     * @param nums
     */
    public static void arrayPop(int startNo, int countNum, int nums) {
        //
        if (startNo < 1 || startNo > nums) {
            System.out.println("参数错误");
            return;
        }

        // 定义一个数组
        int arr[] = new int[nums + 1];
        // 先初始化数组
        for (int i = 0; i <= nums; i++) {
            arr[i] = i + 1;
        }
        int count = nums;
        //key是第一次简化后应该被显示出来的数组下标，startNo+countNum-1是个数，再减1就是那个数的下标
        int key = (startNo + countNum - 2) % count;
        for (int i = 1; i <= count - 1; i++) //循环N-1次取出N-1个那么只剩1个了，即剩下被赦免那个
        {
            System.out.print(arr[key] + "\n");   //把要取出的人显示出来
            if (key < count - 1)   //如果取出的数不是最后一个，要把这个数后面的数前移
            {
                //这里用覆盖的方法，比如取出的数是a[2]，那么将a[3]、a[4]……向前覆盖
                for (int j = key; j <= count - 2; j++) {
                    //假如覆盖3次以后，那么数组最后面的3个数是没有实际意义的，就不必向前覆盖，即前移到n-2
                    //j<=n-2是因为 a[j]=a[j+1];即最后会是a[n-2]=a[n-1];最后一个位置没有意义
                    arr[j] = arr[j + 1];
                }
            }
            //将人数减少，数组是不变的，但是数组后面无意义的数就不算了，即假装数组在变短，数组只有前面有意义
            count--;
            key = (key + countNum - 1) % count; //这里更新下一个应该被取出的数在数组里的下标
        }
        //输出最后一个数，即被赦免的数
        System.out.print(arr[0]);

    }
}


/**
 * 节点类
 */
class Node {
    private int no; //编号
    private Node next; // 下一节点

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

/**
 * 单向环形链表
 */
class CircleSingleLinkedList {
    private Node first = null; // 第一个节点

    // 创建指定数量的单向环形链表
    public void create(int nums) {
        if (nums < 2) {
            System.out.println("至少需要2个节点");
            return;
        }

        // 辅助变量，指向当前节点
        Node current = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);

            // 第一个节点
            if (i == 1) {
                first = node;
                first.setNext(first); // 构成环形
                current = first;
            } else {
                current.setNext(node); // 新节点加入环中
                node.setNext(first); // 新节点指向第一个形成环
                current = node; // 移动当前指针
            }

        }
    }

    // 遍历输出
    public void show() {
        if (first == null) {
            System.out.println("空链表");
            return;
        }
        Node current = first;
        while (true) {
            System.out.println(current.getNo());
            // 到最后一个，则退出
            if (current.getNext() == first) {
                break;
            }
            current = current.getNext();
        }

    }

    /**
     * 出圈序列
     *
     * @param startNo，开始位置节点
     * @param countNum，数到几
     * @param nums，初始共有多少个节点
     */
    public void pop(int startNo, int countNum, int nums) {
        // 先进行数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入错误");
            return;
        }

        // 创建辅助指针，初始为最后一个节点,以后随first移动，但落后first一个位置，first遍历前移
        Node helper = first;
        while (true) {
            // 遍历结束
            if (helper.getNext() == first) {
                break;
            }
            // 移动到下一节点
            helper = helper.getNext();
        }

        // 先移动到指定的起始位置
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始报数，出列，直到圈中只有一个节点
        while (true) {
            // 只有一个节点，则结束
            if (helper == first) {
                break;
            }
            // 让first,helper同时移动countNum-1次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 此时，first指向的节点就是要出列的节点
            System.out.printf("出列的是%d\n", first.getNo());

            first = first.getNext();
            helper.setNext(first);
        }

        //
        System.out.printf("最后留在圈中的节点是:%d\n", helper.getNo());


    }

}

