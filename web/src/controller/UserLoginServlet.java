package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

public class UserLoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 4629050876629157526L;

    public UserLoginServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        String phone;
        name = req.getParameter("name");
        phone = req.getParameter("phone");
        Boolean result = util.JdbcUtil.login(name,phone);
        if(result){
            req.getSession();
            resp.sendRedirect("index.html");
        }else{
            resp.sendRedirect("LoginError.html");
        }
    }
}
