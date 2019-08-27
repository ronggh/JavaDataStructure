package binarysorttree;

public class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.add(node);
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

    //查找要删除的结点
    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        }
        return null;
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root != null) {
            return root.searchParent(value);

        }
        return null;
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        }

        //1.需求先去找到要删除的结点  targetNode
        Node targetNode = search(value);
        //如果没有找到要删除的结点
        if (targetNode == null) {
            return;
        }
        // 只有一个根节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        //去找到targetNode的父结点
        Node parent = searchParent(value);


        //如果要删除的结点是叶子结点
        if (targetNode.left == null && targetNode.right == null) {
            //判断targetNode 是父结点的左子结点，还是右子结点
            if (parent.left != null && parent.left.value == value) { //是左子结点
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {//是由子结点
                parent.right = null;
            }
        }
        //删除有两颗子树的节点
        else if (targetNode.left != null && targetNode.right != null) {
            // 向右子树找到最小值的节点，并删除
            int minVal = delRightTreeMin(targetNode.right);
            targetNode.value = minVal;
        }
        // 删除只有一颗子树的结点
        else {
            //如果要删除的结点有左子结点
            if (targetNode.left != null) {
                if (parent != null) {
                    //如果 targetNode 是 parent 的左子结点
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else { //  targetNode 是 parent 的右子结点
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            } else { //如果要删除的结点有右子结点
                if (parent != null) {
                    //如果 targetNode 是 parent 的左子结点
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else { //如果 targetNode 是 parent 的右子结点
                        parent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }
            }
        }
    }

    /**
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 2. 删除node 为根结点的二叉排序树的最小结点
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

}
