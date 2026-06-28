
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NumberFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=UTF-8");

        String num = request.getParameter("num");

        try {
            Integer.parseInt(num);
            chain.doFilter(request, response);
        } catch (NumberFormatException e) {
            PrintWriter out = response.getWriter();
            out.println("<h2>你输入的内容不是数字，请重新输入</h2>");
            out.println("<a href='p1.html'>返回</a>");
        }
    }

    @Override
    public void destroy() {
    }
}