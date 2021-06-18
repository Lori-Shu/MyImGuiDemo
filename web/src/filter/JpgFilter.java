package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class JpgFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int i = Integer.parseInt(servletRequest.getParameter("age"));
        if (i < 70) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter pw = servletResponse.getWriter();
            pw.print("<center><font style = \"color : red ;font-size : 70px\">注意身体!</font></center>");
        }
    }
}
