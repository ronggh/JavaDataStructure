package linkedlist;

public class SingleLinkedList {
    private DataNode head =  new DataNode(0,"");

    //
    public void add(DataNode node){
        DataNode temp = head;
        // 遍历链表，找到最后一个节点
        while(true){
            if(temp.next == null){
                break;
            }
            //
            temp = temp.next;
        }
        // 新节点加入到最后
        temp.next = node;
    }

    public boolean isEmpty(){
        if(head.next == null){
            return true;
        }
        return false;
    }
    // 显示链表
    public void show(){
        if(isEmpty()){
            System.out.println("链表为空！");
            return;
        }

        DataNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        //
        DataNode node1= new DataNode(1,"宋江");
        DataNode node2= new DataNode(2,"卢俊义");
        DataNode node3= new DataNode(3,"吴用");
        DataNode node4= new DataNode(4,"林冲");

        //
        SingleLinkedList sll = new SingleLinkedList();
        sll.add(node1);
        sll.add(node2);
        sll.add(node3);
        sll.add(node4);

        sll.show();

    }
}
