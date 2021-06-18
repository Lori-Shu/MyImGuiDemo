package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QuestionSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Iterator i = connmap.keySet().iterator();
       Connection conn = null;
       List questions = null;
        while(i.hasNext()){
            conn = (Connection) i.next();
            if((Boolean) connmap.get(conn)){
                connmap.put(conn,false);
                questions = util.JdbcUtil.questionSelect(conn);
                connmap.put(conn,true);
                break;
            }
        }
        req.setAttribute("questions",questions);
        req.getRequestDispatcher("questionSelectResult.jsp").forward(req,resp);
    }
}
