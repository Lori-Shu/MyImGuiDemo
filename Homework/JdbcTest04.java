import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
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
            String sql = "select * from dept";
            //ִ��sql���
            rs = statement.executeQuery(sql);
            //�����ѯ���
            while(rs.next()) {
                int deptno=rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                System.out.println(" ���ű�ţ� "+deptno+" �������ƣ� "+dname+" ����λ�ã� "+loc);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                if (conn != null) {
                    try {
                        conn.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }