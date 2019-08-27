package avl;

public class AvlTreeTest {
    public static void main(String[] args) {
        // 左旋转
        //int[] arr = {4,3,6,5,7,8};
        // 右旋转
        //int[] arr = { 10, 12, 8, 9, 7, 6 };
        // 双旋转
        int[] arr = {10, 11, 7, 6, 8, 9};
        AvlTree avlTree = new AvlTree();
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]), false);
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("未平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8

        AvlTree avlTree2 = new AvlTree();
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree2.add(new Node(arr[i]), true);
        }
        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree2.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree2.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree2.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree2.getRoot());//8
    }
}
