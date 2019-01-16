package com.codecool.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "purchase", urlPatterns = {"/purchase"}, loadOnStartup = 2)
public class PurchaseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        ShoppingCart.add(new Item(request.getParameter("name"),Double.parseDouble(request.getParameter("price"))));
        response.sendRedirect("/");
    }
}

