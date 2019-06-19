package linkedlist;

public class DataNode {
    private int no;
    private String name;
    DataNode next;

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
