package tree;

/**
 * 二叉树的顺序存储
 * 适用于完全二叉树
 * 如当前节点对应数组下标为：index, 则其:
 *     左子树对应数组下标为：2 * index + 1
 *     右子树对应数组下标为：2 * index + 2
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        //创建一个 ArrBinaryTree
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        // 前序遍历
        System.out.println("前序遍历：");
        arrayBinaryTree.preOrder(); // 1,2,4,5,3,6,7

        // 中序遍历
        System.out.println("\n中序遍历：");
        arrayBinaryTree.infixOrder(); // 4,2,5,1,6,3,7

        // 后序遍历
        System.out.println("\n后序遍历：");
        arrayBinaryTree.postOrder(); // 4，5，2，6，7，3，1
    }
}

class ArrayBinaryTree{
    private int[] array;//存储数据结点的数组

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    //重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者 array.length = 0
        if(array == null || array.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.printf("%d  ",array[index]);
        //向左递归遍历,左子树下标为 2 * index + 1
        if((index * 2 + 1) < array.length) {
            preOrder(2 * index + 1 );
        }
        //向右递归遍历,右子树下标为 2 * index + 2
        if((index * 2 + 2) < array.length) {
            preOrder(2 * index + 2);
        }
    }

    // 中序遍历
    public void infixOrder() {
        infixOrder(0);
    }
    // 中序遍历
    public void infixOrder(int index) {
        //如果数组为空，或者 array.length = 0
        if(array == null || array.length == 0) {
            System.out.println("数组为空，不能按照二叉树的中序遍历");
        }

        //向左递归遍历,左子树下标为 2 * index + 1
        if((index * 2 + 1) < array.length) {
            infixOrder(2 * index + 1 );
        }
        //输出当前这个元素
        System.out.printf("%d  ",array[index]);
        //向右递归遍历,右子树下标为 2 * index + 2
        if((index * 2 + 2) < array.length) {
            infixOrder(2 * index + 2);
        }
    }

    //后序遍历
    public void postOrder() {
        postOrder(0);
    }
    // 后序遍历
    public void postOrder(int index) {
        //如果数组为空，或者 array.length = 0
        if(array == null || array.length == 0) {
            System.out.println("数组为空，不能按照二叉树的中序遍历");
        }

        //向左递归遍历,左子树下标为 2 * index + 1
        if((index * 2 + 1) < array.length) {
            postOrder(2 * index + 1 );
        }

        //向右递归遍历,右子树下标为 2 * index + 2
        if((index * 2 + 2) < array.length) {
            postOrder(2 * index + 2);
        }
        //输出当前这个元素
        System.out.printf("%d  ",array[index]);
    }
}
