package hashtable;

public class MyHashTable {
    private EmployeeLinkedList[] empLinkedListArray;
    private int size; //表示有多少条链表

    //构造器
    public MyHashTable(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmployeeLinkedList[size];
        // ！！！需要分别初始化每个链表！！！
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    //添加雇员
    public void add(Employee emp) {
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);

    }
    //遍历所有的链表,遍历hashtab
    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id,查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Employee emp = empLinkedListArray[empLinkedListNO].findEmployeeById(id);
        if(emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    //编写散列函数, 使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

}

