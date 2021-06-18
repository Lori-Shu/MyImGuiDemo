package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QuestionFind extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 8516588955109944653L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(req.getParameter("no"));
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Connection conn = util.ConnGetUtil.get(connmap);
        List list = util.JdbcUtil.questionFind(no,conn);
        connmap.put(conn,true);
        req.setAttribute("findResult",list);
        req.getRequestDispatcher("questionFindResult.jsp").forward(req,resp);
    }
}
