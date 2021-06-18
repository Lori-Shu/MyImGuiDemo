import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //ע������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "guang20010427";
            conn = DriverManager.getConnection(url, user, password);
            //��ȡsql������
            statement = conn.createStatement();
            String sql = "insert into dept(deptno,dname,loc) values(60,'���貿','10����')";
            //ִ��sql���
            int count = statement.executeUpdate(sql);
            System.out.println(count == 1 ? "����ɹ�" : "����ʧ��");
            //�����ѯ���
        } catch (SQLException e) {
            e.printStackTrace();

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}