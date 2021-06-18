package util;

import UserQuestion.Question;
import UserQuestion.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JdbcUtil {
    public static boolean add(String name, String sex, String age, String phone) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rcount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "guang20010427");
            String sql = "insert into userinformation(Name,Sex,Age,Phone) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, age);
            ps.setString(4, phone);
            rcount = ps.executeUpdate();
            System.out.println(rcount == 1);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rcount == 1;
    }

    public static List select() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        List Users = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "guang20010427");
            String sql = "select * from userinformation";
            ps = conn.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                int no = result.getInt(1);
                String name = result.getString(2);
                String sex = result.getString(3);
                String age = result.getString(4);
                String phone = result.getString(5);
                User user = new User(no, name, sex, age, phone);
                Users.add(user);

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return Users;
    }

    public static Boolean delete(int no) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rcount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "guang20010427");
            String sql = "delete  from userinformation where no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);
            rcount = ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rcount == 1;
    }

    public static Boolean login(String name, String phone) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        int recount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "guang20010427");
            String sql = "select count(*) from userinformation where name=? and phone = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            result = ps.executeQuery();
            if (result.next()) {
                recount = result.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return recount == 1;
    }

    public static boolean add(String name, String sex, String age, String phone, Connection conn) {
        PreparedStatement ps = null;
        int rcount = 0;
        try {
            String sql = "insert into userinformation(Name,Sex,Age,Phone) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, age);
            ps.setString(4, phone);
            rcount = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rcount == 1;
    }
    public static Boolean questionAdd(String question,String answerA,String answerB,String answerC,String answerD,String answer,Connection conn){
        PreparedStatement ps = null;
        int rcount = 0;
        try {
            String sql = "insert into questions(question,answerA,answerB,answerC,answerD,answer) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, question);
            ps.setString(2, answerA);
            ps.setString(3, answerB);
            ps.setString(4, answerC);
            ps.setString(5, answerD);
            ps.setString(6, answer);
            rcount = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rcount==1;
    }
    public static List questionSelect(Connection conn) {
        PreparedStatement ps = null;
        ResultSet result = null;
        List<Question> questions = new ArrayList();
        try {
            String sql = "select * from questions";
            ps = conn.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                int no = result.getInt(1);
                String questionx = result.getString(2);
                String answerA = result.getString(3);
                String answerB = result.getString(4);
                String answerC = result.getString(5);
                String answerD = result.getString(6);
                String answer = result.getString(7);
                Question question = new Question(no,questionx , answerA, answerB, answerC,answerD,answer);
                questions.add(question);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return questions;
    }
    public static List questionFind(int no,Connection conn) {
        PreparedStatement ps = null;
        ResultSet result = null;
        List questionlist = new ArrayList();
        try {
            String sql = "select * from questions where No = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,no);
            result = ps.executeQuery();
            while(result.next()) {
                String questionx = result.getString(2);
                String answerA = result.getString(3);
                String answerB = result.getString(4);
                String answerC = result.getString(5);
                String answerD = result.getString(6);
                String answer = result.getString(7);
                questionlist.add(no);
                questionlist.add(questionx);
                questionlist.add(answerA);
                questionlist.add(answerB);
                questionlist.add(answerC);
                questionlist.add(answerD);
                questionlist.add(answer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return questionlist;
    }
    public static Boolean questionDelete(int no,Connection conn) {
        PreparedStatement ps = null;
        int rcount = 0;
        try {
            String sql = "delete  from questions where no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);
            rcount = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rcount == 1;
    }
    public static Boolean questionUpdate(int no,String question,String answerA,String answerB,String answerC,String answerD,String answer,Connection conn){
        PreparedStatement ps = null;
        int rcount = 0;
        String sql = "update questions set question = ?,answerA = ?,answerB= ?,answerC = ?,answerD = ?,answer = ? where no = ? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,question);
            ps.setString(2,answerA);
            ps.setString(3,answerB);
            ps.setString(4,answerC);
            ps.setString(5,answerD);
            ps.setString(6,answer);
            ps.setInt(7,no);
            rcount = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rcount == 1;
    }
    public static List getTest(Connection conn) {
        PreparedStatement ps = null;
        ResultSet result = null;
        List<Question> testlist = new ArrayList();
        try {
            String sql = "select * from questions order by rand() limit 0,4";
            ps = conn.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()) {
                int no = result.getInt(1);
                String question = result.getString(2);
                String answerA = result.getString(3);
                String answerB = result.getString(4);
                String answerC = result.getString(5);
                String answerD = result.getString(6);
                String answer = result.getString(7);
                Question q = new Question(no,question,answerA,answerB,answerC,answerD,answer);
                testlist.add(q);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return testlist;
    }
}

