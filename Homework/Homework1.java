public class Homework1{
    public static void main(String[] args){
        int sum= 1;
        java.util.Scanner s=new java.util.Scanner(System.in);
        System.out.print("请输入一个正整数");
        int i=s.nextInt();
        for(;i>0;--i){
            sum=sum*i;
        }System.out.println("此正整数的阶乘为 "+sum);
    }
}