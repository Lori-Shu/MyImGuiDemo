public class Homework1{
    public static void main(String[] args){
        int sum= 1;
        java.util.Scanner s=new java.util.Scanner(System.in);
        System.out.print("������һ��������");
        int i=s.nextInt();
        for(;i>0;--i){
            sum=sum*i;
        }System.out.println("���������Ľ׳�Ϊ "+sum);
    }
}