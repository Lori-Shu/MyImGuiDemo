public class Homework{
    public static void main(String[] args){
      int j=0;
        for(int i=0;i<1000;++i){
          if(i%7==0){
              continue;
          }j=j+i;
        }System.out.println("1000���ڲ��ܱ�7����������֮��Ϊ "+j);
    }
}