import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // For demonstration purposes, we will just check if the username and password are "admin"
        if ("aaa".equals(username) && "123".equals(password)) {
            // response.setContentType("text/html;charset=UTF-8");
            // PrintWriter out = response.getWriter();
            // out.println("<h1>Login successful!</h1>");
            // request.getRequestDispatcher("/getdatetime").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/getdatetime");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>Login failed. Invalid username or password.</h1>");
        }
    }
}
