import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //设置HTTP响应的内容类型为HTML的方法调用
        response.setContentType("text/html");
       // 消除浏览器缓存
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
       response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
       response.setDateHeader("Expires", 0); // 过期时间设置为0.
 

        //输出HTML内容到客户端
       PrintWriter out = response.getWriter();

        out.println("<a href='datetimeservlet'>DateTime</a> <br>");
        out.println("<a href='weatherservlet'>Weather</a>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}