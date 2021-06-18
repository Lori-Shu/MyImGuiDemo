package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class ConnGetUtil {
    public static Connection get(Map connmap){
        Iterator i = connmap.keySet().iterator();
        Connection conn = null;
        while(i.hasNext()){
            Object x = i.next();
            if((Boolean) connmap.get(x)){
                connmap.put(x,false);

                conn = (Connection) x;
                break;
            }
        }
        return conn;
    }
    public static Connection get(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","guang20010427");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
