package linkedlist;

public class DataNode {
    protected int no;
    protected String name;
    protected DataNode next;

    public DataNode() {
    }

    public DataNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "DataNode{" +
                "no=" + no +
                ", name=" + name +
                '}';
    }
}
