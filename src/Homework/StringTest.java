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
//String���equals�����ѱ���д���Ƚ����ݡ�
//ֻҪ����д���ķ�������������Ϊʲô���ͣ����õĶ�����д��ķ�������
