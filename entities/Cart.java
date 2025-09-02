package com.tns.fooddeliverysystem.entities;

// Imports added for Map and HashMap
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a customer's shopping cart.
 */
public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public void addItem(FoodItem foodItem, int quantity) {
        this.items.put(foodItem, this.items.getOrDefault(foodItem, 0) + quantity);
    }

    public void removeItem(FoodItem foodItem) {
        this.items.remove(foodItem);
    }
    
    public void clearCart() {
        this.items.clear();
    }
}