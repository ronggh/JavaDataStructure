package tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        ThreadedHeroNode root = new ThreadedHeroNode(1, "tom");
        ThreadedHeroNode node2 = new ThreadedHeroNode(3, "jack");
        ThreadedHeroNode node3 = new ThreadedHeroNode(6, "smith");
        ThreadedHeroNode node4 = new ThreadedHeroNode(8, "mary");
        ThreadedHeroNode node5 = new ThreadedHeroNode(10, "king");
        ThreadedHeroNode node6 = new ThreadedHeroNode(14, "dim");

        //二叉树，后面要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以node5:即编号为10的节点测试
        ThreadedHeroNode leftNode = (ThreadedHeroNode) node5.getLeft();
        ThreadedHeroNode rightNode = (ThreadedHeroNode) node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1

        //当线索化二叉树后，不能再使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6

    }
}
