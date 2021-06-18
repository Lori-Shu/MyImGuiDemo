import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcTest03{
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //��ȡ�����ļ��е�jdbc��Ϣ
            ResourceBundle rb = ResourceBundle.getBundle("jdbc");
            //ע������
            String driver = rb.getString("Driver");
            Class.forName(driver);
            //��ȡ����
            String url = rb.getString("url");
            String user = rb.getString("user");
            String password = rb.getString("password");
            conn = DriverManager.getConnection(url, user, password);
            //��ȡsql������
            statement = conn.createStatement();
            String sql = "insert into dept(deptno,dname,loc) values(1,'���㲿','1����')";
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