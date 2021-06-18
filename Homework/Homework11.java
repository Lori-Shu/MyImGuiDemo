public class Homework11{
public static void main(String[] args){
    student x= new student("张三",20,"上海松江东华大学","123321","123698547");
    String 邮编地址 = x.getPostAddress();
    System.out.println(邮编地址);
}
}
class student{
    private String name;
    private int age;
    private String address;
    private String zipCode;
    private String mobile;
    public student(String n,int a,String b,String c,String d){
        name=n;
        age=a;
        address=b;
        zipCode=c;
        mobile=d;
    }
    public void setName(String n){
        name = n;
        return;
    }
    public String getName(){
        return name;
    }
    public void setAge(int n){
        age = n;
        return;
    }
    public int getAge(){
        return age;
    }
    public void setAddress(String n){
        address = n;
        return;
    }
    public String getAddress(){
        return address;
    }
    public void setZipCode(String n){
        zipCode = n;
        return;
    }
    public String getZipCode(){
        return zipCode;
    }
    public void setMobile(String n){
        mobile = n;
        return;
    }
    public String getMobile(){
        return mobile;
    }
    public String getPostAddress(){
        return address+zipCode;
    }
}