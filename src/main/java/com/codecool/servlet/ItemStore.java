package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemStore {
    private static List<Item> stockItems = new ArrayList<>();

    public static void add(Item itemToAdd){
        stockItems.add(itemToAdd);
    }

    public static void remove(Integer id){
        stockItems = stockItems.stream().filter(item-> !item.getId().equals(id)).collect(Collectors.toList());
    }

    public static List<Item> getStockItems() {
        return stockItems;
    }
}
