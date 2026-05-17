import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException
    {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
    {
        System.out.println("before filtering......");
        
        //判断已经登录
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp; 
    	HttpSession session = request.getSession();
    	String login = (String)session.getAttribute("loginsuccess");
    	if("ok".equals(login))
        {
            try{
                chain.doFilter(request, response);
             }
             catch(Exception e)
             {
                e.printStackTrace();
             }
        }
        else
        {   
             //根据如果用户访问的url进行判定，如果是登录页面index.htm，允许访问
             String uri = request.getRequestURI();
             System.out.println("uri:" + uri);  // /myweb/index.htm   /myweb/login
             int position = uri.lastIndexOf("/");             
             uri = uri.substring(position);

             if ("/index.htm".equals(uri) || "/login".equals(uri) || uri.endsWith(".htm") || uri.endsWith(".css") || uri.endsWith(".jpg"))
             {   
                 try{
                    chain.doFilter(request, response);
                 }
                 catch(Exception e)
                 { 
                     e.printStackTrace();
                 }
             }
             else
             {
                 //否则重定向到登录页面
                 // 消除浏览器缓存
                 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                 response.setDateHeader("Expires", 0); // 过期时间设置为0.
                 
                 try{
                      request.getRequestDispatcher("/index.htm").forward(request, response);
                 }
                 catch(Exception e)
                 { 
                     e.printStackTrace();
                 }
             }
        }
        System.out.println("after filtering......");
    }
         
    public void destroy()
    {


    }

}