package Homework;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        //初始化界面
        Map<String,String> userAndpswd= initUI();
        //验证用户名和密码
        boolean successlog = logIn(userAndpswd);
        //输出结果
        System.out.println(successlog ? " 登陆成功！ " : " 登陆失败！ ");
    }

    /**
     *
     * @param userAndpswd 用户用户名密码Map集合
     * @return 用户登录成功与否
     */
    private static boolean logIn(Map<String, String> userAndpswd) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Boolean r = false;
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");//连接驱动
            //获得连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode","root","guang20010427");
            //创造表达对象(获取数据库操作对象)
            stmt = conn.createStatement();
            //执行sql语句
            String sql = "select 用户名,用户密码 from t_user ";
            rs = stmt.executeQuery(sql);
            //处理查询结果
            Iterator it = userAndpswd.entrySet().iterator();
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey()+"   "+e.getValue());
            while(rs.next()){
                System.out.println(rs.getString("用户名")+"  "+rs.getString("用户密码"));
                if (rs.getString("用户名").equals( e.getKey())){
                        if(rs.getString("用户密码").equals( e.getValue())) {
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
        } finally{//释放资源
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
*初始化用户界面
*  @return 返回登录用户信息
 */
   private static Map<String,String> initUI() {
       Scanner s = new Scanner(System.in);
       System.out.println(" 用户名： ");
       String user = s.nextLine();
       System.out.println(" 密码： ");
       String pswd = s.nextLine();
       Map<String,String> userAndpswd= new HashMap<>();
       userAndpswd.put(user ,pswd);

        return userAndpswd;
    }
}
