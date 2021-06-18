package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class GetTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Connection conn = util.ConnGetUtil.get(connmap);
        List testList = util.JdbcUtil.getTest(conn);
        connmap.put(conn,true);
        HttpSession session = req.getSession(false);
        session.setAttribute("testList",testList);
        req.setAttribute("testList",testList);
        req.getRequestDispatcher("getTest.jsp").forward(req,resp);
    }
}
