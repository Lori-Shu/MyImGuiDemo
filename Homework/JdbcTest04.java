import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取配置文件中的jdbc信息
            ResourceBundle rb = ResourceBundle.getBundle("jdbc");
            //注册驱动
            String driver = rb.getString("Driver");
            Class.forName(driver);
            //获取连接
            String url = rb.getString("url");
            String user = rb.getString("user");
            String password = rb.getString("password");
            conn = DriverManager.getConnection(url, user, password);
            //获取sql语句对象
            statement = conn.createStatement();
            String sql = "select * from dept";
            //执行sql语句
            rs = statement.executeQuery(sql);
            //处理查询结果
            while(rs.next()) {
                int deptno=rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                System.out.println(" 部门编号： "+deptno+" 部门名称： "+dname+" 部门位置： "+loc);
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