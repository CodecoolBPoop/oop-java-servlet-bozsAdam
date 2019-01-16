package com.codecool.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "remove", urlPatterns = {"/remove"}, loadOnStartup = 3)
public class RemoveServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        ShoppingCart.remove(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/cart");
    }
}

