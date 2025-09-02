package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
public class FoodService {
	private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    /**
     * Retrieves a restaurant by its ID.
     * @param restaurantId The ID of the restaurant.
     * @return The Restaurant object if found, otherwise null.
     */
    public Restaurant getRestaurantById(int restaurantId) {
        for (Restaurant r : restaurants) {
            if (r.getId() == restaurantId) {
                return r;
            }
        }
        return null;
    }

    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> allFoodItems = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            allFoodItems.addAll(restaurant.getMenu());
        }
        return allFoodItems;
    }

    /**
     * Adds a food item to a specific restaurant's menu.
     * @param restaurantId The ID of the restaurant.
     * @param foodItem The food item to add.
     */
    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.addFoodItem(foodItem);
        } else {
            System.out.println("Restaurant with ID " + restaurantId + " not found.");
        }
    }

    /**
     * Removes a food item from a specific restaurant's menu.
     * @param restaurantId The ID of the restaurant.
     * @param foodItemId The ID of the food item to remove.
     */
    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodItemId);
        } else {
            System.out.println("Restaurant with ID " + restaurantId + " not found.");
        }
    }
}
