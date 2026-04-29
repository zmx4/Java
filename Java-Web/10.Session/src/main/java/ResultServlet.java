import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String username = (String) request.getAttribute("username");
        @SuppressWarnings("unchecked")
        List<String> hobbies = (List<String>) request.getAttribute("hobbies");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>注册成功</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>注册成功！</h2>");
        out.println("<p><strong>用户名：</strong> " + username + "</p>");
        out.println("<h3>爱好：</h3>");
        // out.print("<p>" + hobbies.toString() + "</p>");
        if(hobbies != null && !hobbies.isEmpty()) {
            out.println("<ul>");
            for(String hobby : hobbies) {
                out.println("<li>" + hobby + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>没有选择爱好</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}