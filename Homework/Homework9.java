public class Homework9{
    public static void main(String[]  args){
    System.out.println("������һ��������");
    java.util.Scanner s=new java.util.Scanner(System.in);
    int in=s.nextInt();
    System.out.println("ͨ���ݹ�����ۼӽ�� "+ sum(in));

    }
    public static int sum(int x){
        if(x==1){
            return x;
        }
        return x+sum(x-1);
    }
}