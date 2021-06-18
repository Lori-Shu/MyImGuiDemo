public class Homework2 {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("请输入一个大于1的正整数 ");
        int x = s.nextInt();
        for (int i = 2; i <= x; ++i) {
             if (x % i != 0 ) {
                 if (i == (x-1) ) {
                     System.out.println("输入的数为质数");
                     break;
                    }
             } else if (i == x ) {
                     System.out.println("输入的数为质数");
                     break;
                 }
                else {
                System.out.println("输入的数不是质数");
                break;
            }
            }
        }
    }/*标准答案
    boolean zhishu=true;
    for(int i=2;i<num;++i){
    if(num%i==0){
    zhishu=false;
    break;
    }
    }
    System.out.println(num+（zhishu? "是":"不是"）+“质数”);
    */

