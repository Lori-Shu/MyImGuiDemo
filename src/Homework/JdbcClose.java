package Homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcClose {
    private JdbcClose(){}
    static void close(Connection conn, Statement stmt, ResultSet rs){

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
    }

