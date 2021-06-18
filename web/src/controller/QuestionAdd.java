package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;

public class QuestionAdd extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 5383791859596355147L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String question = req.getParameter("question");
        String answerA = req.getParameter("answerA");
        String answerB = req.getParameter("answerB");
        String answerC = req.getParameter("answerC");
        String answerD = req.getParameter("answerD");
        String answer = req.getParameter("answer");
        Map connmap = (Map)req.getServletContext().getAttribute("connmap");
        Boolean result = false;
        Iterator i = connmap.keySet().iterator();
        Connection conn = null;
        while(i.hasNext()) {
            conn = (Connection) i.next();
            if ((Boolean) connmap.get(conn)) {
                connmap.put(conn,false);
                result = util.JdbcUtil.questionAdd(question, answerA, answerB, answerC, answerD, answer, conn);
                connmap.put(conn,true);
                break;
            }
        }
            req.setAttribute("result",result);
            req.getRequestDispatcher("/questionAddResult.jsp").forward(req, resp);



}
}
