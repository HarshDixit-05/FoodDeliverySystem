package com.tns.fooddeliverysystem.application;

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.CustomerService;
import com.tns.fooddeliverysystem.services.FoodService;
import com.tns.fooddeliverysystem.services.OrderService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FoodDeliverySystem {
private static final Scanner scanner = new Scanner(System.in);
    
    // Service layer instances to handle business logic
    private static final CustomerService customerService = new CustomerService();
    private static final FoodService foodService = new FoodService();
    private static final OrderService orderService = new OrderService();
    
    // A simple counter to generate unique order IDs
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        // Main application loop
        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    return; // Exit the main method, terminating the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Displays and handles the menu for Admin users.
     */
    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addRestaurant(); break;
                case 2: addFoodItemToRestaurant(); break;
                case 3: removeFoodItemFromRestaurant(); break;
                case 4: viewRestaurantsAndMenus(); break;
                case 5: viewOrders(); break;
                case 6: addDeliveryPerson(); break;
                case 7: assignDeliveryPerson(); break;
                case 8:
                    System.out.println("Exiting Admin Module");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Displays and handles the menu for Customer users.
     */
    private static void customerMenu() {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addCustomer(); break;
                case 2: viewRestaurantsAndMenus(); break;
                case 3: addFoodToCart(); break;
                case 4: viewCart(); break;
                case 5: placeOrder(); break;
                case 6: viewCustomerOrders(); break;
                case 7:
                    System.out.println("Exiting Customer Module");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // --- ADMIN FUNCTIONALITY ---

    private static void addRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Restaurant Name: ");
        String name = scanner.nextLine();
        foodService.addRestaurant(new Restaurant(id, name));
        System.out.println("Restaurant added successfully!");
    }

    private static void addFoodItemToRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        if (foodService.getRestaurantById(restaurantId) == null) {
            System.out.println("Restaurant not found.");
            return;
        }
        System.out.print("Enter Food Item ID: ");
        System.out.print("Enter Food Item ID: ");
        int foodId = Integer.parseInt(scanner.nextLine().trim());
        scanner.nextLine();
        System.out.print("Enter Food Item Name: ");
        String foodName = scanner.nextLine();
        System.out.print("Enter Food Item Price: ");
        double foodPrice = scanner.nextDouble();
        scanner.nextLine();
        foodService.addFoodItemToRestaurant(restaurantId, new FoodItem(foodId, foodName, foodPrice));
        System.out.println("Food item added successfully!");
    }
    
    private static void removeFoodItemFromRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        if (foodService.getRestaurantById(restaurantId) == null) {
            System.out.println("Restaurant not found.");
            return;
        }
        System.out.print("Enter Food Item ID to remove: ");
        int foodItemId = scanner.nextInt();
        scanner.nextLine();
        foodService.removeFoodItemFromRestaurant(restaurantId, foodItemId);
        System.out.println("Food item removed successfully!");
    }

    private static void viewRestaurantsAndMenus() {
        System.out.println("\nRestaurants and Menus:");
        List<Restaurant> restaurants = foodService.getRestaurants();
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants available.");
            return;
        }
        for (Restaurant r : restaurants) {
            System.out.print("Restaurant ID: " + r.getId() + ", Name: " + r.getName());
            if (r.getMenu().isEmpty()) {
                System.out.println(" - Menu is empty.");
            } else {
                for (FoodItem item : r.getMenu()) {
                    System.out.print(" - Food Item ID: " + item.getId() + ", Name: " + item.getName() + ", Price: Rs. " + item.getPrice());
                }
                System.out.println();
            }
        }
    }
    
    private static void viewOrders() {
        System.out.println("\nAll Orders:");
        List<Order> orders = orderService.getOrders();
        if(orders.isEmpty()) {
            System.out.println("No orders have been placed yet.");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    
    private static void addDeliveryPerson() {
        System.out.print("Enter Delivery Person ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Delivery Person Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact No.: ");
        long contact = scanner.nextLong();
        scanner.nextLine();
        orderService.addDeliveryPerson(new DeliveryPerson(id, name, contact));
        System.out.println("Delivery person added successfully!");
    }

    private static void assignDeliveryPerson() {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Delivery Person ID: ");
        int deliveryPersonId = scanner.nextInt();
        scanner.nextLine();
        orderService.assignDeliveryPersonToOrder(orderId, deliveryPersonId);
    }

    // --- CUSTOMER FUNCTIONALITY ---

    private static void addCustomer() {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Username: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact No.: ");
        long contact = scanner.nextLong();
        scanner.nextLine();
        customerService.addCustomer(new Customer(id, name, contact));
        System.out.println("Customer created successfully!");
    }
    
    private static void addFoodToCart() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        Restaurant restaurant = foodService.getRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        System.out.print("Enter Food Item ID: ");
        int foodItemId = scanner.nextInt();
        scanner.nextLine();
        FoodItem foodItem = null;
        for (FoodItem item : restaurant.getMenu()) {
            if (item.getId() == foodItemId) {
                foodItem = item;
                break;
            }
        }

        if (foodItem == null) {
            System.out.println("Food item not found in this restaurant's menu.");
            return;
        }

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        customer.getCart().addItem(foodItem, quantity);
        System.out.println("Food item added to cart!");
    }
    
    private static void viewCart() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        
        System.out.println("\nCart for " + customer.getUsername() + ":");
        Map<FoodItem, Integer> cartItems = customer.getCart().getItems();
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        
        double totalCost = 0;
        for (Map.Entry<FoodItem, Integer> entry : cartItems.entrySet()) {
            FoodItem item = entry.getKey();
            Integer quantity = entry.getValue();
            double itemCost = item.getPrice() * quantity;
            totalCost += itemCost;
            System.out.println("Food Item: " + item.getName() + ", Quantity: " + quantity + ", Cost: Rs. " + itemCost);
        }
        System.out.println("Total Cost: Rs. " + totalCost);
    }
    
    private static void placeOrder() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        if (customer.getCart().getItems().isEmpty()) {
            System.out.println("Cannot place an order with an empty cart.");
            return;
        }

        Order newOrder = new Order(orderIdCounter, customer);
        orderService.placeOrder(newOrder);
        System.out.println("Order placed successfully! Your order ID is: " + orderIdCounter);
        
        // Clear the customer's cart after the order is placed
        customer.getCart().clearCart();
        
        orderIdCounter++; // Increment for the next order
    }

    private static void viewCustomerOrders() {
        System.out.print("Enter Customer ID to view their orders: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        
        System.out.println("\nOrders for " + customer.getUsername() + ":");
        boolean hasOrders = false;
        for (Order order : orderService.getOrders()) {
            if (order.getCustomer().getUserId() == customerId) {
                System.out.println(order);
                hasOrders = true;
            }
        }

        if (!hasOrders) {
            System.out.println("You have not placed any orders yet.");
        }
    }
}
