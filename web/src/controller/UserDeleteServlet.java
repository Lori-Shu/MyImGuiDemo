package controller;

import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

public class UserDeleteServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 624936738703290914L;

    public UserDeleteServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean result = JdbcUtil.delete(Integer.parseInt(req.getParameter("no")));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if (result) {
            pw.print("成功删除");
        } else {
            pw.print("失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
