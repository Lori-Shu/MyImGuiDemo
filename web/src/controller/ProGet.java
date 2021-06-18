package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProDao;
import prodetail.ProDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ProGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map connmap = (Map) req.getServletContext().getAttribute("connmap");
        Connection conn = util.ConnGetUtil.get(connmap);
        connmap.put(conn,false);
        String idS = req.getParameter("id");
        ProDao pd = new ProDao();
        List pl =null;
        if(idS != "") {
            Integer id = Integer.valueOf(idS);
             pl = pd.getDetail(id, conn);
                 }else {
             pl = pd.getDetail(conn);
        }
        connmap.put(conn, true);
        ObjectMapper om =new ObjectMapper();
        String jsonpdl = om.writeValueAsString(pl);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print(jsonpdl);

    }
}
