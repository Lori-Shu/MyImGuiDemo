package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

public class QuestionDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(req.getParameter("no"));
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Connection conn = util.ConnGetUtil.get(connmap);
        Boolean result = util.JdbcUtil.questionDelete(no,conn);
        connmap.put(conn,true);
        req.setAttribute("result",result);
        req.getRequestDispatcher("questionDeleteResult.jsp").forward(req,resp);
    }
}
