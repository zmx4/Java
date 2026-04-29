import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/getdatetime")
public class GetDateTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        try {
            if((boolean) session.getAttribute("isLogin"))
            {
                out.println("<p>" + new Date() + "</p>");
            }else
            {
                out.println("<p>" + "未登录" + "</p>");
            }
        } catch (Exception e) {
            out.println("<p>" + "未登录" + "</p>");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
