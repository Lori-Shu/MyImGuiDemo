package Homework;

import java.io.Serial;
import java.io.Serializable;

public class Mystack implements Serializable {
    @Serial
    private static final long serialVersionUID = 1500212861050956804L;

    public static void main(String[] args) {
        Mystack sk = new Mystack();
        sk.push(new Object());
        sk.push(new String("哈哈哈"));
        sk.push(new String("嘿嘿嘿"));
        sk.push(new String("好尴尬"));
        sk.push(new String("换换换"));
        sk.push(new String("你好世界！"));
        sk.push(new String("我裂开来"));
        sk.pop();
        sk.pop();
        sk.pop();
        sk.pop();
        sk.pop();
        sk.pop();
        sk.pop();
    }
    private int x = -1;
    public Mystack() {
    }

    private Object[] stack = new Object[5];
    void push(Object o){
        if(x == 4){
            System.out.println("压栈失败 "+"栈中第五个元素为："+stack[4]+" 栈满！");
            return;
        }
     x = x+1;
        stack[x] = o;
    }
    void pop(){
        if(x==-1){
            System.out.println("栈空！无法弹栈！");
            return;
        }
        stack[x]=null;
        x=x-1;
    }
}
