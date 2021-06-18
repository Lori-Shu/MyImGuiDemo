package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContexListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<Connection,Boolean> connmap = new HashMap();
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            for (int i = 1; i < 21; ++i) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "guang20010427");
                System.out.println(conn + "已创建");
                connmap.put(conn, true);
            }
            DriverManager.deregisterDriver(driver);
            sce.getServletContext().setAttribute("connmap",connmap);
        } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Map connmap = (Map)sce.getServletContext().getAttribute("connmap");
        Iterator i =connmap.keySet().iterator();
        while(i.hasNext()){
            try {
                Connection x = (Connection) i.next();
                x.close();
                System.out.println(x+"已关闭！");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
