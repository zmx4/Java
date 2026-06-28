import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/p2")
public class P2SessionServlet extends AddToSessionServlet {
    @Override
    protected String getSessionAttributeName() {
        return "p2";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        super.doGet(request, response);
        request.getRequestDispatcher("/getresult").forward(request, response);
    }
}