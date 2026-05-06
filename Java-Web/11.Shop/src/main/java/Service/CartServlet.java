package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import Entity.Cart;
import Entity.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.println("<!DOCTYPE html><html><head><title>购物车概览</title></head><body>");
            out.println("<h2>购物车</h2>");
            out.println("<table border='1'><tr><th>商品名称</th><th>单价</th><th>数量</th></tr>");

            Cart cart = (Cart) request.getSession().getAttribute("cart");
            for (Map.Entry<Goods, Integer> entry : cart.getItems().entrySet()) {
                Goods g = entry.getKey();
                int qty = entry.getValue();
                out.println("<tr>");
                out.println("<td>" + g.getName() + "</td>");
                out.println("<td>" + g.getPrice() + "</td>");
                out.println("<td>" + qty + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<h3>总价: " + cart.getTotalPrice() + " 元</h3>");
            out.println("<br><a href='sports.html'>返回继续购物</a>");
            out.println("</body></html>");
        }
        catch (Exception e){
            e.printStackTrace();
            out.println("<html><body><h2>购物车为空</h2><br><a href='sports.html'>返回继续购物</a></body></html>");
        }
    }
}
