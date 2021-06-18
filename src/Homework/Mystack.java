package Homework;

import java.io.Serial;
import java.io.Serializable;

public class Mystack implements Serializable {
    @Serial
    private static final long serialVersionUID = 1500212861050956804L;

    public static void main(String[] args) {
        Mystack sk = new Mystack();
        sk.push(new Object());
        sk.push(new String("������"));
        sk.push(new String("�ٺٺ�"));
        sk.push(new String("������"));
        sk.push(new String("������"));
        sk.push(new String("������磡"));
        sk.push(new String("���ѿ���"));
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
            System.out.println("ѹջʧ�� "+"ջ�е����Ԫ��Ϊ��"+stack[4]+" ջ����");
            return;
        }
     x = x+1;
        stack[x] = o;
    }
    void pop(){
        if(x==-1){
            System.out.println("ջ�գ��޷���ջ��");
            return;
        }
        stack[x]=null;
        x=x-1;
    }
}
