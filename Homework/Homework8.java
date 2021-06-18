public class Homework8{
    public static int zhiShu(int x){
        if(x==1){
            return 2;
        }
        for(int i=x+1;true;++i){
            for(int j=2;j<=(i/2+1);j++){
                if(i%j != 0){
                    if(j==i/2+1) {
                        return i;
                    }
                }
                else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        System.out.println("������һ��������");
        java.util.Scanner s=new java.util.Scanner(System.in);
        int y=s.nextInt();
        System.out.println("���� " + y + " ����С������ " + zhiShu(y));

    }
}