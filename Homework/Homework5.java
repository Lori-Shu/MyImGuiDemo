public class Homework5 {
    public static void main(String[] args) {
        for(int i=1;i<=1000;++i){
            int sum=0;
            for(int k=1;k<i;++k){
                if(i%k==0){
                    sum=sum+k;
                }
            }
            if(sum==i){
                System.out.println("ÍêÊý£º "+i);
            }
        }
    }
}