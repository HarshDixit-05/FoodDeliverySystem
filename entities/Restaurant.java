package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a restaurant with a menu of food items.
 */
public class Restaurant   {
    private int id;
    private String name;
    private List<FoodItem> menu;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        // THE FIX IS HERE: This line creates the actual list object.
        // Without it, 'menu' would be null, causing the program to crash.
        this.menu = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    /**
     * Adds a food item to the restaurant's menu.
     * @param item The food item to add.
     */
    public void addFoodItem(FoodItem item) {
        // This line is now safe because the menu was created in the constructor.
        this.menu.add(item);
    }

    /**
     * Removes a food item from the menu by its ID.
     * @param foodItemId The ID of the food item to remove.
     */
    public void removeFoodItem(int foodItemId) {
        this.menu.removeIf(item -> item.getId() == foodItemId);
    }

    @Override
    public String toString() {
        return "Restaurant{id=" + id + ", name='" + name + "', menu=" + menu + "}";
    }
}