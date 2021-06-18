package controller;

import UserQuestion.User;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.List;

public class UserSelectServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -3959730257763204431L;

    public UserSelectServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("<center>" +
                "<table border=\"2px\">"+
         "<tr>"+
                "<th>用户编号</th>" +
                "<th>用户姓名</th>" +
                "<th>性别</th>" +
                "<th>年龄</th>" +
                "<th>电话号码</th>"+
                "</tr>");
        List users= JdbcUtil.select();

        for(Object user:users){
            User u = (User)user;
                int no=u.getNo();
            String name = u.getName();
            String sex = u.getSex();
            String age = u.getAge();
            String phone = u.getPhone();
            pw.print(
                    "<tr>" +
                    "<td >"+
                    "<form action=\"UserDelete\">"+
                    "<input type=\"text\" name=\"no\" readonly=\"readonly\" size=\"7px\"  value=\""+no+"\"/>"+
                    "</td>" +
                      "<td>"+name+"</td>" +
            "<td>"+sex+"</td>"+
            "<td>"+age+"</td>"+
                    "<td>"+phone+"</td>"+
                    "<td>"+"<input type=\"submit\"  value=\"删除\"/>"+
                    "</form>"+"</td>"+
                    "</tr>");
        }
        pw.print("</table>" +
                "</center>");
    }
}
