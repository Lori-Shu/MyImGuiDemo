package Homework;

public class HotelHomework {
    static Room[][] rooms = new Room[10][20];
     static {
        for (int i = 0; i < 10; ++i) {
            for(int j = 0; j<20;++j){
                rooms[i][j]=new Room();
                rooms[i][j].setNumber((i+1)*100+j+1);
                rooms[i][j].setType("������ͳ�׷�");
                rooms[i][j].setCondition("��Ԥ��");
            }
        }
    }
}
 class Controller{
     public static void main(String[] args) {
         HotelHomework.rooms[9][19].book();
         HotelHomework.rooms[0][0].book();
         HotelHomework.rooms[1][14].setType("��׼���˼�");
         view();
     }
    static void view(){
         for(int i = 0;i<10;++i){
             System.out.println(" ��"+(i+1)+" ��:");
             for(int j = 0; j<20 ; j++){
                 System.out.print(" ����ţ�"+HotelHomework.rooms[i][j].getNumber()+
                         " ���ͣ�"+HotelHomework.rooms[i][j].getType()+" ״̬��"+HotelHomework.rooms[i][j].getCondition()+"||||");
             }
             System.out.println();
             System.out.println();
             System.out.println();
         }
    }
}
class Room{
    private int number;
    private String type;
    private String condition;

    public Room() {
    }

    public Room(int number, String type, String condition) {
        this.number = number;
        this.type = type;
        this.condition = condition;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
         this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    void book(){
        condition = "�ѱ�Ԥ����";
        System.out.println(number+"�ѱ�Ԥ��");
    }
    void over(){
        condition = "��Ԥ��";
        System.out.println(number+"���˷�");
    }
}
