package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class CityGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Connection conn = util.ConnGetUtil.get(connmap);
        connmap.put(conn,false);
        Integer id = Integer.valueOf(req.getParameter("id"));
        ProDao pd = new ProDao();
        List cl =null;
        cl = pd.getCity(id,conn);
        connmap.put(conn, true);
        ObjectMapper om =new ObjectMapper();
        String jsonpdl = om.writeValueAsString(cl);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print(jsonpdl);


    }
}
