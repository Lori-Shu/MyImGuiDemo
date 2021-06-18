package Homework;

import java.sql.*;

public class JdbcTest01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);//ע������
            //��ȡ����
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "guang20010427";
            conn = DriverManager.getConnection(url, user, password);
            //��ȡsql������
            statement = conn.createStatement();
            String sql = "insert into dept(deptno,dname,loc) values(50,'mdept','1013a')";
            //ִ��sql���
            int count = statement.executeUpdate(sql);
            System.out.println(count == 1 ? "����ɹ�" : "����ʧ��");
            //�����ѯ���
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
