import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class WeatherServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         WeatherService wst = new WeatherService();
         String result = wst.getWeather();
         PrintWriter out = response.getWriter();
         out.println(result);
    }
}
