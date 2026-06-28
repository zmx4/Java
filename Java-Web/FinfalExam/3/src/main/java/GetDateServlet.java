import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/getresult")
public class GetDateServlet extends HttpServlet {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            int a = Integer.parseInt(request.getParameter("a"));
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM t_numers WHERE num = ?");
            pstmt.setInt(1, a);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                out.println("<h1>查询结果: " + rs.getInt("num") + "在表中" +"</h1>");
            }else {
                out.println("<h1>查询结果: " + a + "不在表中" +"</h1>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}