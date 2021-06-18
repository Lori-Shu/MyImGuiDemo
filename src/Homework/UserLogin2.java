package Homework;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogin2 {
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boolean r = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//��������
            //�������
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode", "root", "guang20010427");
            //��ȡԤ�������ݿ��������
            String sql = "select �û���,�û����� from t_user where �û��� = ? and �û����� = ?";
            ps = conn.prepareStatement(sql);
            //��ռλ����ֵ
            ps.setString(1, userAndpswd.get("user"));
            ps.setString(2, userAndpswd.get("pswd"));
            rs = ps.executeQuery();
            //�����ѯ���
            if (rs.next()) {
                r = true;
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
            if(ps != null){
                try{
                    ps.close();
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
        System.out.print(" �û����� ");
        String user = s.nextLine();
        System.out.print(" ���룺 ");
        String pswd = s.nextLine();
        Map<String,String> userAndpswd= new HashMap<>();
        userAndpswd.put("user",user);
        userAndpswd.put("pswd",pswd);

        return userAndpswd;
    }
}
