import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FailServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //设置HTTP响应的内容类型为HTML的方法调用
        response.setContentType("text/html");

        //从Servlet请求域中获取存储的用户名和密码信息
        String username = (String)request.getAttribute("username");
        String password = (String)request.getAttribute("password");

        boolean nResult = username.equals("admin");
        boolean pRseult = password.equals("123456");

        PrintWriter out = response.getWriter();

        //判断登录失败原因
        if (!nResult || !pRseult)
        {
            out.println("Login Failed: <br>");
            if (!nResult) {
                //request.setAttribute("usernameError", "用户名不正确");
                out.println("The username:" + username + " is incorrect <br>");
            }
            if (!pRseult) {
                //request.setAttribute("passwordError", "密码不正确");
                out.println("The password:" + password + " is incorrect <br>");
            }
            out.println("<a href='index.htm'>Return Index</a>");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}