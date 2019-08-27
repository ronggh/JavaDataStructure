package binarysorttree;

public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1,2, 3, 5, 7, 9, 10, 12

        //
        //删除叶子结点
//        binarySortTree.delNode(2);
//        binarySortTree.delNode(5);
//        binarySortTree.delNode(9);
//        binarySortTree.delNode(12);

        // 删除只有一个子树的节点
//        binarySortTree.delNode(1);

        // 删除有2个子树的节点
        binarySortTree.delNode(7);

        binarySortTree.delNode(10);

        System.out.println("删除结点后");
        binarySortTree.infixOrder();

        System.out.println("根节点为：" + binarySortTree.getRoot());
    }


}
