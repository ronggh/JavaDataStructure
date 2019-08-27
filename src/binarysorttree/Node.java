package binarysorttree;

public class Node {
    //
    int value;
    Node left;
    Node right;

    //
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    /**
     * 添加结点的方法
     * 递归的形式添加结点，注意需要满足二叉排序树的要求
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value) {
            //如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else { //添加的结点的值大于 当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        // 递归遍历左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出当前节点
        System.out.println(this);
        // 递归遍历右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value) {
        //找到就是该结点
        if (value == this.value) {
            return this;
        }
        //如果查找的值小于当前结点，向左子树递归查找
        if (this.left != null && value < this.value) {
            return this.left.search(value);
        }
        //如果查找的值不小于当前结点，向右子树递归查找
        if (this.right != null && value >= this.value) {
            return this.right.search(value);
        }
        //
        return null;

    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        }
        //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
        //向左子树递归查找
        if (value < this.value && this.left != null) {
            return this.left.searchParent(value);
        }
        //如果查找的值大于等于当前结点的值, 并且当前结点的右子结点不为空
        // 向右子树递归查找
        if (value >= this.value && this.right != null) {
            return this.right.searchParent(value);
        }

        return null; // 没有找到父结点
    }
}
