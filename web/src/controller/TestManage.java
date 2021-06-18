package controller;

import UserQuestion.Question;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TestManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int score = 0;
        HttpSession session=req.getSession();
        List testList = (List) session.getAttribute("testList");
        for(Object q : testList){
            Question question = (Question) q;
            if(question.getAnswer().equals(req.getParameter("answer_"+question.getNo()))){
                score+=25;

            }
        }
        req.setAttribute("score",score);
        req.getRequestDispatcher("score.jsp").forward(req,resp);
    }
}
