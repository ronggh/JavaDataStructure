package HuffmanTree;

public class Node implements Comparable<Node>{
    int value; // 结点权值
    Node left; // 指向左子结点
    Node right; // 指向右子结点


    public Node(int value) {
        this.value = value;
    }

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        // 表示从小到大排序
        return this.value - o.value;
    }
}
