package Listener;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class OnlineUserCount implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        synchronized (this) {
            Integer count = (Integer) context.getAttribute("onlineCount");
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            context.setAttribute("onlineCount", count);
            System.out.println("A user connected. Current online users: " + count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        synchronized (this) {
            Integer count = (Integer) context.getAttribute("onlineCount");
            if (count != null && count > 0) {
                count--;
                context.setAttribute("onlineCount", count);
                System.out.println("A user disconnected. Current online users: " + count);
            }
        }
    }
}
