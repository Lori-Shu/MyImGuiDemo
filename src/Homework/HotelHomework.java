package Homework;

public class HotelHomework {
    static Room[][] rooms = new Room[10][20];
     static {
        for (int i = 0; i < 10; ++i) {
            for(int j = 0; j<20;++j){
                rooms[i][j]=new Room();
                rooms[i][j].setNumber((i+1)*100+j+1);
                rooms[i][j].setType("豪华总统套房");
                rooms[i][j].setCondition("可预订");
            }
        }
    }
}
 class Controller{
     public static void main(String[] args) {
         HotelHomework.rooms[9][19].book();
         HotelHomework.rooms[0][0].book();
         HotelHomework.rooms[1][14].setType("标准单人间");
         view();
     }
    static void view(){
         for(int i = 0;i<10;++i){
             System.out.println(" 第"+(i+1)+" 层:");
             for(int j = 0; j<20 ; j++){
                 System.out.print(" 房间号："+HotelHomework.rooms[i][j].getNumber()+
                         " 类型："+HotelHomework.rooms[i][j].getType()+" 状态："+HotelHomework.rooms[i][j].getCondition()+"||||");
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
        condition = "已被预订！";
        System.out.println(number+"已被预订");
    }
    void over(){
        condition = "可预订";
        System.out.println(number+"已退房");
    }
}
