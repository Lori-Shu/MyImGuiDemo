public class Homework{
    public static void main(String[] args){
      int j=0;
        for(int i=0;i<1000;++i){
          if(i%7==0){
              continue;
          }j=j+i;
        }System.out.println("1000以内不能被7整除的整数之和为 "+j);
    }
}