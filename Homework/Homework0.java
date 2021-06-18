public  class Homework0{
    public static void main(String[] args){
        int x=2;
        for(int i=1;i<101;++i){
            if(i%2 == 0){
                x=x+i;
            }else{
                x=x-i;
            }
        }System.out.println("½á¹ûÎª "+x);
    }
}