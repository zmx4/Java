import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String[] hobbies = request.getParameterValues("hobbies");

        if(confirmPassword == null || !password.equals(confirmPassword)) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>Registration failed. Passwords do not match.</h1>");
            return;
        }

        UserInfo userInfo = new UserInfo(username, password, hobbies);

        // For demonstration purposes, we will just print the user info to the console
        System.out.println("Username: " + userInfo.getUsername());
        System.out.println("Password: " + userInfo.getPassword());
        System.out.println("Hobbies: " + userInfo.getHobbies());

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Registration successful!</h1>");
    }
}
