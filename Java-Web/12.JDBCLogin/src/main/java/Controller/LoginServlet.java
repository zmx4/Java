package Controller;

import java.io.*;
import java.sql.SQLException;

import Services.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import util.DbUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        try {
            if (LoginService.authenticate(DbUtil.getConnection(), username, password)) {
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/service/getdatetime");
            } else {
                response.setContentType("text/html;charset=UTF-8");
                out.println("<h1>登录失败,用户名或密码错误</h1>");
                request.getRequestDispatcher("/index.html").include(request, response);
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
