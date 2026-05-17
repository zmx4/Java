import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class DateTimeServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
    	String login = (String)session.getAttribute("loginsuccess");
    	
    	if("ok".equals(login))
    	{
        DateTimeService dts = new DateTimeService();
        String result = dts.getDateTime();
        PrintWriter out = response.getWriter();
        out.println(result);  
        }
        else{
        	response.getWriter().println("login failed");
        }
    }
}
