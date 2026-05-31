package Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/service/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        try{
            if(session != null && session.getAttribute("username") != null)
            {
                chain.doFilter(request, response);
            }else {
                out.println("<p>" + "未登录" + "</p>");
            }
        }catch (Exception e){
            out.println("<p>" + "未登录" + "</p>");
            return;
        }
    }

}
