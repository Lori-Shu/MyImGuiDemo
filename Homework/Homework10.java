public class Homework10{
    public static void main(String[] args){
     Husband �ɷ�0 = new Husband(123456 , "����", "2000��1��1��",null );
     Wife ����0 = new Wife(654321, "����" , "2002��2��22��" ,�ɷ�0 );
     �ɷ�0.wife=����0;
        System.out.println(�ɷ�0.name+" �ɷ��������ӵ�����Ϊ "+ �ɷ�0.wife.name);
    }
}
class Husband{
    int id;
    String name;
    String chuShengRiQi;
    Wife wife;
    public  Husband(){
        System.out.println("�޲����Ĺ��췽��");
    }
    public  Husband(int x,String y, String z, Wife w){
        id = x;
        name = y;
        chuShengRiQi= z;
        wife =w;
        System.out.println("���֤�� "+ id +";  ���� "+ name+";  �������� "+ chuShengRiQi +";  ���� "+wife );
    }
}
class Wife{
    int id;
    String name;
    String chuShengRiQi;
    Husband husband;
    public  Wife(){
        System.out.println("�޲����Ĺ��췽��");
    }
    public  Wife(int x,String y, String z, Husband w){
        id = x;
        name = y;
        chuShengRiQi= z;
        husband =w;
        System.out.println("���֤�� "+ id +";  ���� "+ name+";  �������� "+ chuShengRiQi +";  �ɷ� "+husband );
    }
}