public class Homework6{
    public static void main(String[] args){
        for(int i=1;true;++i){
            int j = i;
            for(int k=1;k<10;++k) {
                j =(j/2)-1;
            }
            if(j==1){
                System.out.println("第一天摘了 "+i+" 个桃子");
                break;
            }
        }
    }
}