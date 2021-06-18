public  class Homework7{
    public static void main(String[] args){
    System.out.println("请输入一个不多于五位的正整数");
    java.util.Scanner s=new java.util.Scanner(System.in);
    int in=s.nextInt();
    int j=0;
    int k=0;
    for(int i=10;i<=100000;i=i*10){
        j=j+1;
        if((in/i)==0){
            System.out.println("输入的数是 "+j+" 位数");
            break;
        }
    }
        for(int i=10;i<=100000;i=i*10){
            if((in%i-k)/(i/10)==0){
                break;
            }
            System.out.println((in%i-k)/(i/10));
            k=in%i;
        }
    }
}