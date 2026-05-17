import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");     //从HTTP请求中获取用户名的值
        String password = request.getParameter("password");     //从HTTP请求中获取密码的值
         
        //向request域中存储数据
        request.setAttribute("username", username);
        request.setAttribute("password", password);


        //判断是否符合登录条件
        LoginService ls = new LoginService();
        boolean canLogin = ls.allowLogin(username, password);
         
        if(canLogin)
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginsuccess","ok");

           // 消除浏览器缓存
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0); // 过期时间设置为0.
            
            //request.getRequestDispatcher("/main.htm").forward(request, response);
            
            
            //生成随机数，重定向URL
            RandomString rs = new RandomString();
            String sessionID = rs.random();
            String redirectURL = request.getContextPath() + "/mainservlet?sessionID=" + sessionID;

            response.sendRedirect(redirectURL);
        }
	    else
        {
            //导向FailServlet.java
	        request.getRequestDispatcher("/failservlet").forward(request, response);
        }
    }
    
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doGet(request, response);
    }
}
