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
            out.println("<h1>注册失败,两次密码不一致</h1>");
            request.getRequestDispatcher("/index.html").include(request, response);
            return;
        }
        if(username == null || username.trim().isEmpty()) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>注册失败,用户名不能为空</h1>");
            request.getRequestDispatcher("/index.html").include(request, response);
            return;
        }
        

        UserInfo userInfo = new UserInfo(username, password, hobbies);

        System.out.println("Username: " + userInfo.getUsername());
        System.out.println("Password: " + userInfo.getPassword());
        System.out.println("Hobbies: " + userInfo.getHobbies());

        // response.setContentType("text/html;charset=UTF-8");
        // PrintWriter out = response.getWriter();
        // out.println("<h1>Registration successful!</h1>");
        request.setAttribute("username", userInfo.getUsername());
        request.setAttribute("hobbies", userInfo.getHobbies());
        request.getRequestDispatcher("/result").forward(request, response);
    }
}
