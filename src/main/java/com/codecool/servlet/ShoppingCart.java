package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private static List<Item> purchasedItems = new ArrayList<>();

    public static void add(Item itemToAdd){
        purchasedItems.add(itemToAdd);
    }

    public static void remove(Integer id){
        purchasedItems = purchasedItems.stream().filter(item-> !item.getId().equals(id)).collect(Collectors.toList());
    }

    public static List<Item> getPurchasedItems() {
        return purchasedItems;
    }
}
