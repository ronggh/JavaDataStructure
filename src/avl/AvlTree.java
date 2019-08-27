package avl;

public class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //添加结点的方法
    public void add(Node node,Boolean isBalance) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.add(node,isBalance);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }


}
