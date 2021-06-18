package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        if (uri.contains("Login") || uri.equals("/myweb/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (req.getSession(false) != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("LoginError.html");
        }
    }
}
