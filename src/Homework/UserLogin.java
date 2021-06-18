package Homework;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        //��ʼ������
        Map<String,String> userAndpswd= initUI();
        //��֤�û���������
        boolean successlog = logIn(userAndpswd);
        //������
        System.out.println(successlog ? " ��½�ɹ��� " : " ��½ʧ�ܣ� ");
    }

    /**
     *
     * @param userAndpswd �û��û�������Map����
     * @return �û���¼�ɹ����
     */
    private static boolean logIn(Map<String, String> userAndpswd) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Boolean r = false;
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");//��������
            //�������
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode","root","guang20010427");
            //���������(��ȡ���ݿ��������)
            stmt = conn.createStatement();
            //ִ��sql���
            String sql = "select �û���,�û����� from t_user ";
            rs = stmt.executeQuery(sql);
            //�����ѯ���
            Iterator it = userAndpswd.entrySet().iterator();
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey()+"   "+e.getValue());
            while(rs.next()){
                System.out.println(rs.getString("�û���")+"  "+rs.getString("�û�����"));
                if (rs.getString("�û���").equals( e.getKey())){
                        if(rs.getString("�û�����").equals( e.getValue())) {
                             r = true;
                             break;
                        }

                }
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{//�ͷ���Դ
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt != null){
                try{
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


        }
        return r;
    }

    /**
*��ʼ���û�����
*  @return ���ص�¼�û���Ϣ
 */
   private static Map<String,String> initUI() {
       Scanner s = new Scanner(System.in);
       System.out.println(" �û����� ");
       String user = s.nextLine();
       System.out.println(" ���룺 ");
       String pswd = s.nextLine();
       Map<String,String> userAndpswd= new HashMap<>();
       userAndpswd.put(user ,pswd);

        return userAndpswd;
    }
}
