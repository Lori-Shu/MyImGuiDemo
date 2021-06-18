public class ForHomework{
    public static void main(String[] args){
        for(int i=1;i<10;++i){
            for(int k=1;k<=i;++k){
                System.out.print(k+" * "+i+" = "+i*k+" ");
            }
            System.out.println();
        }
    }
}