public class Homework4{
    public static void main(String[] args){
        double sum=0;
        for(int i=1;true;++i){
            sum=sum+2.5;
            if(i%5==0){
                sum=sum-6;
            }
            if(sum>=100){
                System.out.println(sum+"她需要 "+i+" 天存到100元");
                break;
            }
        }
    }
}