/**
 * @(#)ServletHelloWorld.java
 *
 *
 * @author 
 * @version 1.00 2026/4/15
 */

import java.io.*;
import java.time.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletHello  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    {
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       pw.println("<h1>Hello World Servlet!</h1>");
       Date now = new Date();
       pw.println("<p1>"+now.toString()+"</p1>");
       
    }
}