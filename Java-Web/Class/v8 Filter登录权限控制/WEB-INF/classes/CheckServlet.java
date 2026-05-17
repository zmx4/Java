import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class CheckServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        //所有商品的遍历
        List buycar = (List)session.getAttribute("buy");
        Iterator it = buycar.iterator();
        String str = "";
        while( it.hasNext() )
        {
           BuyItem bi = (BuyItem)it.next();
           str += bi.code;
           str += " ";
           str += bi.count; 
        }

        response.getWriter().println(str);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
     }


}