public class Homework10{
    public static void main(String[] args){
     Husband 丈夫0 = new Husband(123456 , "张三", "2000年1月1日",null );
     Wife 妻子0 = new Wife(654321, "李四" , "2002年2月22日" ,丈夫0 );
     丈夫0.wife=妻子0;
        System.out.println(丈夫0.name+" 丈夫对象的妻子的名字为 "+ 丈夫0.wife.name);
    }
}
class Husband{
    int id;
    String name;
    String chuShengRiQi;
    Wife wife;
    public  Husband(){
        System.out.println("无参数的构造方法");
    }
    public  Husband(int x,String y, String z, Wife w){
        id = x;
        name = y;
        chuShengRiQi= z;
        wife =w;
        System.out.println("身份证号 "+ id +";  姓名 "+ name+";  出生日期 "+ chuShengRiQi +";  妻子 "+wife );
    }
}
class Wife{
    int id;
    String name;
    String chuShengRiQi;
    Husband husband;
    public  Wife(){
        System.out.println("无参数的构造方法");
    }
    public  Wife(int x,String y, String z, Husband w){
        id = x;
        name = y;
        chuShengRiQi= z;
        husband =w;
        System.out.println("身份证号 "+ id +";  姓名 "+ name+";  出生日期 "+ chuShengRiQi +";  丈夫 "+husband );
    }
}