public class IfHomework0{
    public static void main(String[ ] args){
        java.util.Scanner s=new java.util.Scanner(System.in);
        System.out.print("������������Ϣ��0��ʾ���죬1��ʾ���죩");
        int weather=s.nextInt();
        System.out.println("�������Ա���Ϣ��0��ʾ�У�1��ʾŮ��");
        int sex=s.nextInt();
        String str;
        if(weather!=0 && weather!=1 && sex!=0 && sex!=1){
            str="������Ϣ���Ա���Ϣ�����Ϸ�";
        }
        else if(weather!=0 && weather!=1){
            str="������Ϣ���Ϸ�";
        }else if(sex!=0 && sex!=1){
            str="�Ա���Ϣ���Ϸ�";
        }else if(weather==sex && weather==0){
            str="��һ�Ѵ��ɡ";
        }else if(weather==sex){
            str="�����ɹ˪����ȥ��ˣ";
        }else if(weather==1){
            str="ֱ�����𣬳�ȥ��ˣ";
        }else {
            str="��һ��С��ɡ";
        }System.out.println(str);
    }
}