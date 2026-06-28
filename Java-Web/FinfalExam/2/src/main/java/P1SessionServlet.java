import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/p1")
public class P1SessionServlet extends AddToSessionServlet {
    @Override
    protected String getSessionAttributeName() {
        return "p1";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        super.doGet(request, response);
        request.getRequestDispatcher("/p2.html").forward(request, response);
        System.out.println("p1 "+request.getParameter("p1"));
    }
}