public  class Homework7{
    public static void main(String[] args){
    System.out.println("������һ����������λ��������");
    java.util.Scanner s=new java.util.Scanner(System.in);
    int in=s.nextInt();
    int j=0;
    int k=0;
    for(int i=10;i<=100000;i=i*10){
        j=j+1;
        if((in/i)==0){
            System.out.println("��������� "+j+" λ��");
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