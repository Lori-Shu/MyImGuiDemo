package Homework;

import java.util.Scanner;

public class Homework18 {
    public static void main(String[] args) {
        System.out.println("�������û��������롣");
        Scanner s = new Scanner(System.in);
        System.out.println(" �˺ţ� ");
        String username = s.nextLine();
        System.out.println(" ���룺 ");
        String password = s.nextLine();
        UserService us = new UserService();
        try{
        us.register(username,password);
        }catch(RegisterException re){
            re.printStackTrace();
            System.out.println(re.getMessage());
            return;
        }finally{
            System.out.println("finally...");
        }
    }
}
class UserService{
    public void register(String username,String password) throws RegisterException{
if(null == username || username.length()<6 || username.length()>14){
    throw new RegisterException("������˺ų��Ȳ��Ϲ棡");
}
if(null == password || password.length()<6 || password.length()>14){
    throw new RegisterException("��������볤�Ȳ��Ϲ棡");
}
        System.out.println("ע��ɹ�����ӭ�� "+username);
    }
}
class RegisterException extends RuntimeException{
    public  RegisterException()throws RuntimeException{

    }
    public  RegisterException (String str)throws RuntimeException{
        super(str);
    }
}
