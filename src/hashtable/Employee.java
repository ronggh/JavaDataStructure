package hashtable;

//表示一个雇员
public class Employee {
    // 属性
    public int id;
    public String name;
    public Employee next; //next 默认为 null

    // 构造函数
    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
