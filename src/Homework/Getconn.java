package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Getconn {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Getconn(){}
    static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode", "root", "guang20010427");
        return conn;
    }
}
