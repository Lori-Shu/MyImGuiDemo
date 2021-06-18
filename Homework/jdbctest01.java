import java.sql.*;

public class jdbctest01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement  = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);//注册驱动
            //获取连接
            String url="jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "guang20010427";
            conn = DriverManager.getConnection(url,user,password);
            //获取sql语句对象
            statement = conn.createStatement();
            String sql = "insert into dept(deptno,dname,loc) values(50,'mdept','1013a')";
            //执行sql语句
            int count = statement.executeUpdate(sql);
            System.out.println(count == 1 ?"保存成功":"保存失败");
            //处理查询结果
        }catch(SQLException e){
            e.printStackTrace();

        }
        finally{
            try{if(conn != null){
                conn.close();
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
}
}