import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class BuyServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String[] codes = request.getParameterValues("codechk");
        int count = 0;
        for(String code : codes)
        {
            System.out.println(code);
            count = Integer.parseInt(request.getParameter(code));
            System.out.println(count);
            
            HttpSession session = request.getSession();

            
            //保存用户所选购的商品集合
            List buycar = (List)session.getAttribute("buy"); 
            
            if( buycar == null)
            {
               buycar = new ArrayList();                
            }
 
            BuyItem bi = new BuyItem(code, count);

            buycar.add(bi);
            
            
            session.setAttribute("buy", buycar);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
     }


}