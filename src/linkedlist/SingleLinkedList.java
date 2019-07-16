package linkedlist;

import java.util.Stack;

public class SingleLinkedList {
    private DataNode head = new DataNode(0, "");

    //
    public void add(DataNode node) {
        DataNode temp = head;
        // 遍历链表，找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //
            temp = temp.next;
        }
        // 新节点加入到最后
        temp.next = node;
    }

    // 按DataNode.no号的顺序添加
    public void addByOrder(DataNode node) {
        DataNode temp = this.head;
        boolean flag = false;

        while (true) {
            // 已到链表最后
            if (temp.next == null) {
                break;
            }

            // 找到位置
            if (temp.next.no > node.no) {
                break;
            }
            // 编号已存在
            else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            // 继续向下查找
            temp = temp.next;
        }
        // 已存在，不能添加
        if (flag) {
            System.out.printf("编号为: %d 的节点已存在\n", node.no);
        }
        // 添加
        else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void delete(int no) {
        DataNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("无此节点");
        }
    }

    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    public int length() {
        if (head.next == null) {
            return 0;
        }
        DataNode current = head.next;
        int sum = 0;
        while (current != null) {
            sum++;
            current = current.next;
        }
        return sum;
    }

    // 显示链表
    public void show() {
        if (isEmpty()) {
            System.out.println("链表为空！");
            return;
        }

        DataNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }

    }

    public void reverse(){
        // 空或只有一个节点，无需进行反转
        if(head.next == null || head.next.next == null) return;

        DataNode reverseHead = new DataNode(0,"");

        // 遍历
        DataNode currentNode = head.next;
        DataNode nextNode = null; // 当前节点current的下一个节点

        while(currentNode != null){
            // 先保留原链表中的下一个指向节点
            nextNode = currentNode.next;
            currentNode.next = reverseHead.next;
            reverseHead.next = currentNode;
            currentNode = nextNode;
        }

        head.next = reverseHead.next;
    }

    public void reversePrint(){
        if(head.next == null) return;

        //
        Stack<DataNode> stack = new Stack<>();
        DataNode current  = head.next;
        while(current!=null){
            stack.push(current);
            current = current.next;
        }

        //
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        //
        DataNode node1 = new DataNode(1, "宋江");
        DataNode node2 = new DataNode(2, "卢俊义");
        DataNode node3 = new DataNode(3, "吴用");
        DataNode node4 = new DataNode(4, "林冲");

        //
        SingleLinkedList sll = new SingleLinkedList();
//        sll.add(node1);
//        sll.add(node2);
//        sll.add(node3);
//        sll.add(node4);

        sll.addByOrder(node1);
        sll.addByOrder(node4);
        sll.addByOrder(node2);
        sll.addByOrder(node3);

        //sll.addByOrder(node3);

        sll.show();
        System.out.println("有效长度为：" + sll.length());


        //sll.delete(3);
//        sll.delete(2);
//        sll.delete(3);
//        sll.delete(3);
//        sll.delete(4);
//        System.out.println("删除后-----------");
//        sll.show();
//        System.out.println("有效长度为：" + sll.length());

        //
        System.out.println("反序打印-------");
        sll.reversePrint();

        sll.reverse();
        System.out.println("反转后：");
        sll.show();

    }
}
