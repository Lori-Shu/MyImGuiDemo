package Homework;

import java.sql.*;

public class JdbcTest05 {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            conn = Getconn.getConnection();
            String sql = "select * from emp where ename = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"smith");
            rs =ps.executeQuery();
            while(rs.next()){
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job =rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date date = rs.getDate("hiredate");
                Double sal = rs.getDouble("sal");
                int comm =rs.getInt("comm");
                int deptno = rs.getInt("deptno");
                System.out.println(empno+"  "+ename+"  "+job+"  "+mgr+"  "+date+"  "+sal+ "  "+comm+"  "+deptno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcClose.close(conn,ps,rs);
        }
    }
}
