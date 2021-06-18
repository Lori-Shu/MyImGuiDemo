package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

public class QuestionUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(req.getParameter("no"));
        String question = req.getParameter("question");
        String answerA = req.getParameter("answerA");
        String answerB = req.getParameter("answerB");
        String answerC = req.getParameter("answerC");
        String answerD = req.getParameter("answerD");
        String answer = req.getParameter("answer");
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Connection conn = util.ConnGetUtil.get(connmap);
        Boolean result = util.JdbcUtil.questionUpdate(no,question,answerA,answerB,answerC,answerD,answer,conn);
        connmap.put(conn,true);
        req.setAttribute("result",result);
        req.getRequestDispatcher("questionUpdateResult.jsp").forward(req,resp);
    }
}
