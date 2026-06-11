import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.Gson;

public class ListUserServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		JSONResult result = new JSONResult();
                String uname = request.getParameter("uname");

                //1. 加载驱动
                String jdbcName = "com.mysql.jdbc.Driver";
                try
                {
                    Class.forName(jdbcName); //java反射机制
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                //2. 获取连接
                String url = "jdbc:mysql://localhost:3306/test";
                String dbusername = "root";
                String dbpassword = "";

                Connection con = null;
                try
                {
                    con = DriverManager.getConnection(url, dbusername, dbpassword);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                if (con != null)
                {
                    System.out.println("数据库连接成功！");
                }

                //3. 创建sql语句
                try{
                    //判断用户名是否为空
                    String sql = null;
                    PreparedStatement pst;
                    if (uname == null || uname.isEmpty())
                    {
                        sql = "select id, username, password from t_user ";
                        pst = con.prepareStatement(sql);
                    }else
                    {
                        sql = "select id, username, password from t_user where username=?";
                        pst = con.prepareStatement(sql);
                        pst.setString(1, uname);
                    }

                   //4. 执行sql
                   ResultSet rs = pst.executeQuery();

                   //5. 结果处理
                   User user = null;
                   while (rs.next())
                   {
                       result.code = "200";
                       result.count++;
                       user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                       result.data.add(user);
                    }
                }catch(Exception e)
                {
                    result.code = "404";
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                String resp = gson.toJson(result); //把java对象转换成json字符串
                response.setContentType("application/json");
		response.getWriter().write(resp);

    }

 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doGet(request, response);
    }
}
