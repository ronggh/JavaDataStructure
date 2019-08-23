package tree.threadedbinarytree;

import tree.binarytree.BinaryTree;


public class ThreadedBinaryTree extends BinaryTree {
    private ThreadedHeroNode root;

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private ThreadedHeroNode pre = null;

    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }



    //重载一把threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodes(ThreadedHeroNode node) {

        //如果node==null, 不能线索化
        if(node == null) {
            return;
        }

        //(一)先线索化左子树,递归调用
        threadedNodes((ThreadedHeroNode)node.getLeft());
        //(二)线索化当前结点[有难度]

        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //处理后继结点
        // !!! 实际上后继节点是在下一次递归时通过pre来判定!!!
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)在线索化右子树,递归调用
        threadedNodes((ThreadedHeroNode)node.getRight());

    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        ThreadedHeroNode node = root;
        while(node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while(node.getLeftType() == 0) {
                node = (ThreadedHeroNode)node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while(node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = (ThreadedHeroNode)node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = (ThreadedHeroNode)node.getRight();

        }
    }
}
