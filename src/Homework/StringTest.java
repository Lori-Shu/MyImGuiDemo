package Homework;

public class StringTest {
    public static void main(String[] args) {
        Object o1 = new String("nihao");
        Object o2 = new String("nihao");
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1.equals(o2));
        Object o3 = new Object();
        System.out.println(o3);
    }
}
//String类的equals方法已被重写，比较内容。
//只要类重写过的方法，不管声明为什么类型，调用的都是重写后的方法！！
