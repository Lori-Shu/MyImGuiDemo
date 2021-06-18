public class Homework9{
    public static void main(String[]  args){
    System.out.println("请输入一个正整数");
    java.util.Scanner s=new java.util.Scanner(System.in);
    int in=s.nextInt();
    System.out.println("通过递归求得累加结果 "+ sum(in));

    }
    public static int sum(int x){
        if(x==1){
            return x;
        }
        return x+sum(x-1);
    }
}