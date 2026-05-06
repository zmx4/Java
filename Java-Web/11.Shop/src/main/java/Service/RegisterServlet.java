package Service;

import java.io.*;

import Entity.UserInfo;
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
        String email = request.getParameter("email");
        String confirmPassword = request.getParameter("confirmPassword");
        String[] hobbies = request.getParameterValues("hobbies");

        if(!password.equals(confirmPassword)) {
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
        if(email == null || !email.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>注册失败,邮箱格式不正确</h1>");
            request.getRequestDispatcher("/index.html").include(request, response);
            return;
        }
        

        UserInfo userInfo = new UserInfo(username, password, email,hobbies);

        System.out.println("Username: " + userInfo.getUsername());
        System.out.println("Password: " + userInfo.getPassword());
        System.out.println("Email: " + userInfo.getEmail());
        System.out.println("Hobbies: " + userInfo.getHobbies());


        // response.setContentType("text/html;charset=UTF-8");
        // PrintWriter out = response.getWriter();
        // out.println("<h1>Registration successful!</h1>");
        request.setAttribute("username", userInfo.getUsername());
        request.setAttribute("hobbies", userInfo.getHobbies());
        request.getRequestDispatcher("/result").forward(request, response);
    }
}
