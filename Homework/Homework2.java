public class Homework2 {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("������һ������1�������� ");
        int x = s.nextInt();
        for (int i = 2; i <= x; ++i) {
             if (x % i != 0 ) {
                 if (i == (x-1) ) {
                     System.out.println("�������Ϊ����");
                     break;
                    }
             } else if (i == x ) {
                     System.out.println("�������Ϊ����");
                     break;
                 }
                else {
                System.out.println("���������������");
                break;
            }
            }
        }
    }/*��׼��
    boolean zhishu=true;
    for(int i=2;i<num;++i){
    if(num%i==0){
    zhishu=false;
    break;
    }
    }
    System.out.println(num+��zhishu? "��":"����"��+��������);
    */

