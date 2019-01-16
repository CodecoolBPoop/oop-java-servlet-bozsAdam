package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "webShop", urlPatterns = {"/"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {


    public void init(){
        ItemStore.add(new Item("Asus Rog",1600.0));
        ItemStore.add(new Item("Potters Wand",25002.0));
        ItemStore.add(new Item("Jared Dines Signature Guitar",3000.0));
        ItemStore.add(new Item("Blasius 6 Bass",4000.0));
        ItemStore.add(new Item("The pick of Destiny",9999.0));
        ItemStore.add(new Item("Fallout 4 Playstation Game",30.0));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{

        PrintWriter out = response.getWriter();
        String title = "Coolest Webshop Ever";
        List<Item> items = ItemStore.getStockItems();
        List<String> itemNames = new ArrayList<>();

        out.println(
                "<html>\n" +
                        "<head>" +
                        "<title>" + title + "</title>" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<table>"
        );
        items.forEach(item ->{
            if(!itemNames.contains(item.getName())){
                String name = item.getName();
                double price = item.getPrice();
                out.println("<tr>" +
                        "<td>" + name + "</td>" + "<td>" + price + " USD" + "</td>" + "<td>" + "<a href='/purchase?name=" + name + "&price=" + price + "'> buy </a>" + "</td>" +
                        "</tr>");
                itemNames.add(name);
            }
        });
        out.println("</table>" +
                "<a href='/cart'>Shopping cart(" + ShoppingCart.getPurchasedItems().size() +")</a>" +
                "</body></html>");

    }

}
