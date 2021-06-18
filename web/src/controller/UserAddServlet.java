package controller;

import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class UserAddServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -5109752335310184821L;

    public UserAddServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        Map connmap = (Map)req.getServletContext().getAttribute("connmap");
        Boolean result = false;
        Iterator i = connmap.keySet().iterator();
        Connection conn = null;
        while(i.hasNext()){

             conn = (Connection) i.next();
           if((Boolean) connmap.get(conn)) {
               connmap.put(conn,false);
               Date d1 = new Date();
               result = JdbcUtil.add(username, sex, age, phone, conn);
               Date d2 = new Date();
               connmap.put(conn,true);
               System.out.println(d2.getTime()-d1.getTime()+"毫秒");
               break;
           }
        }
        System.out.println("添加结果"+result);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if (result) {
            pw.print("成功注册");
            //req.getRequestDispatcher("UserSelect").forward(req,resp);
        } else {
            pw.print("失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
