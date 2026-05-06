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

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] codes = request.getParameterValues("codes");
        
        // 从Session中获取购物车，如果没有则新建
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        if (codes != null) {
            for (String code : codes) {
                // 根据商品编号获取对应的数量
                String numStr = request.getParameter(code);
                int count = (numStr != null && !numStr.isEmpty()) ? Integer.parseInt(numStr) : 1;
                
                // 模拟根据编号查询商品信息
                Goods goods = null;
                if ("001".equals(code)) {
                    goods = new Goods("篮球", 100);
                } else if ("002".equals(code)) {
                    goods = new Goods("足球", 120);
                } else if ("003".equals(code)) {
                    goods = new Goods("羽毛球", 80);
                }

                if (goods != null) {
                    // 将商品及数量加入购物车
                    cart.addItem(goods, count);
                }
            }
        }
        
        session.setAttribute("cart", cart);

        // 跳转
        response.sendRedirect(request.getContextPath()+"/cart");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

