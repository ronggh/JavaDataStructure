package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        PolandNotation polandNotation = new PolandNotation();

        String express = "15+((26+3)*4)-7";
        // 字符表达式转为中缀表达式
        List<String> inFixExpression = polandNotation.toInfixExpressionList(express);
        System.out.println("中缀表达式："+inFixExpression);

        // 转为后缀表达式
        List<String> suffixExpression = polandNotation.toSuffixExpression(express);
        System.out.println("后缀表达式："+suffixExpression);

        // 计算后缀表达式的修值
        System.out.printf("计算结果为：%d",polandNotation.calculate(suffixExpression));
    }

    // 字符串表达式转为中缀表达式
    public List<String> toInfixExpressionList(String express) {
        List<String> result = new ArrayList<>();
        int index = 0; // 遍历索引位置
        String numString;// 数字串拼接
        char ch; //

        do {
            ch = express.charAt(index);
            // 非数字直接入栈,ASCII码，0:[48],9:[57]
            if (ch < 48 || ch > 57) {
                result.add("" + ch);
                index++;
            }
            // 数字，则需要进行拼接
            else {
                numString = "";

                while (index < express.length() && ch >=48 && ch <=57) {
                    numString += ch;
                    index++;
                    if (index > express.length() - 1) {
                        break;
                    }
                    ch = express.charAt(index);

                }
                result.add(numString);
            }

        } while (index < express.length());

        return result;
    }

    // 中缀表达式转后缀表过式
    public List<String> toSuffixExpression(String express){
        List<String> result = new ArrayList<>();
        result = toInfixExpressionList(express);

        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈s2
        List<String> s2 = new ArrayList<>(); // 储存中间结果的Lists2

        // 遍历result
        for(String item:result){
            //如果是一个数，加入s2
            if(item.matches("\\d+")) {
                s2.add(item);
            }
            // 左括号直接入栈
            else if (item.equals("(")) {
                s1.push(item);
            }
            // 右括号
            else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while(!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//!!! 将 ( 弹出 s1栈， 消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }

        //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
        return s2;

    }

    // 计算后缀表达式的值
    public  int calculate(List<String> ls) {
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<>();
        // 遍历 ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }

        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}
