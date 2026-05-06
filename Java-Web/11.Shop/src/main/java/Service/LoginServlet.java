package Service;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
		
        // For demonstration purposes, we will just check if the username and password are "admin"
        if ("aaa".equals(username) && "123".equals(password)) {
            // response.setContentType("text/html;charset=UTF-8");
            // PrintWriter out = response.getWriter();
            // out.println("<h1>Login successful!</h1>");
            // request.getRequestDispatcher("/getdatetime").forward(request, response);
//            session.setAttribute("username",username);
//			session.setAttribute("password",password);
			session.setAttribute("isLogin",true);
            response.sendRedirect(request.getContextPath() + "/sports.html");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>Login failed. Invalid username or password.</h1>");
        }
    }
}
