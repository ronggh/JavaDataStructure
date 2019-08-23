package tree.threadedbinarytree;

import tree.binarytree.HeroNode;

public class ThreadedHeroNode extends HeroNode {
    //说明
    //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
    private int leftType;
    private int rightType;

    //
    public ThreadedHeroNode(int no, String name) {
        super(no, name);
    }

    public int getLeftType() {
        return leftType;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public int getRightType() {
        return rightType;
    }
    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}
