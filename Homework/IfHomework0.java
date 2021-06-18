public class IfHomework0{
    public static void main(String[ ] args){
        java.util.Scanner s=new java.util.Scanner(System.in);
        System.out.print("请输入天气信息（0表示雨天，1表示晴天）");
        int weather=s.nextInt();
        System.out.println("请输入性别信息（0表示男，1表示女）");
        int sex=s.nextInt();
        String str;
        if(weather!=0 && weather!=1 && sex!=0 && sex!=1){
            str="天气信息和性别信息均不合法";
        }
        else if(weather!=0 && weather!=1){
            str="天气信息不合法";
        }else if(sex!=0 && sex!=1){
            str="性别信息不合法";
        }else if(weather==sex && weather==0){
            str="打一把大黑伞";
        }else if(weather==sex){
            str="擦点防晒霜，出去玩耍";
        }else if(weather==1){
            str="直接走起，出去玩耍";
        }else {
            str="打一把小花伞";
        }System.out.println(str);
    }
}