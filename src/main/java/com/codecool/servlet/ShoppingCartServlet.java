package com.codecool.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "shoppingCart", urlPatterns = {"/cart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
                "<html>\n" +
                "<head><title>" + "Shopping Cart" + "</title></head>\n" +
                "<body>\n" +
                        "<h1 align= \" center \"> Your freaking awesome Shopping Cart </h1> <table>");

                ShoppingCart.getPurchasedItems().forEach(item->{
                    String name = item.getName();
                    double price = item.getPrice();
                    out.println("<tr>" +
                            "<td>" + name + "</td>" + "<td>" + price + " USD" + "</td>" + "<td>" + "<a href='/remove?id=" + item.getId() + "'> delete </a>" + "</td>" +
                            "</tr>");
                        }
                );
        out.println(
                "</table>");

        double sum = 0;
        for (int i = 0; i < ShoppingCart.getPurchasedItems().size(); i++) {
            sum += ShoppingCart.getPurchasedItems().get(i).getPrice();
        }
        out.println("<h2> Total price: " + sum + " USD </h2>");
        out.println(
                "<a href = '/'>Back to home</a>" +
                "</body>" +
                "</html>"
        );


    }
}
