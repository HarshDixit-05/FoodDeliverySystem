# **🍕 Online Food Delivery System - Core Java Project**

Welcome to the Online Food Delivery System! This is a classic console-based application built entirely in Java, designed to simulate the core functionality of a modern food ordering platform. It's a great example of Object-Oriented Programming (OOP) principles in action, perfect for anyone looking to see how concepts like inheritance, polymorphism, and collections are used to build a real-world application.

## 🌟 About The Project

This project brings a food delivery service to your terminal. It features two main roles: an Admin who manages the restaurants and delivery logistics, and a Customer who can browse, order, and enjoy delicious food. The entire system is self-contained and runs in the console, making it easy to compile and run without any external dependencies.

The main goal was to create a robust and logical system using core Java features, demonstrating a clear separation of concerns between data models (entities), business logic (services), and the user interface (application).

# ✨ Features

The application provides a different set of options depending on the user's role:

# 👤 Admin Menu

Manage Restaurants: Add new restaurants to the system.

Curate Menus: Add or remove food items from any restaurant's menu.

Order Oversight: View all customer orders in the system.

Logistics: Add new delivery personnel and assign them to pending orders.

# 🙋 Customer Menu

Sign Up: Register as a new customer.

Browse Food: View all available restaurants and their complete menus.

Shopping Cart: Add desired food items to a personal cart.

Place Orders: Convert the cart into a confirmed order.

Track Orders: View a history of all placed orders and their current status.

# 🛠️ Built With
Java: The one and only language used for this project.

JDK 17: Developed using Java SE 17.

# 🚀 Getting Started
Ready to try it out? Here’s how to get the project running on your local machine.

Prerequisites

Make sure you have the Java Development Kit (JDK) version 11 or newer installed.

How to Compile and Run

Clone the repository:

git clone [https://github.com/your-username/food-delivery-system.git](https://github.com/your-username/food-delivery-system.git)

Navigate to the project directory:

cd food-delivery-system

Compile all the Java files from the root directory:

javac src/com/tns/fooddeliverysystem/entities/*.java src/com/tns/fooddeliverysystem/services/*.java src/com/tns/fooddeliverysystem/application/*.java

Run the application:

java -cp src com.tns.fooddeliverysystem.application.FoodDeliverySystem

You should now see the main menu in your terminal!

# 📁 Project Structure
The code is organized into three distinct packages for clarity and maintainability:

com.tns.fooddeliverysystem.application: Contains the main FoodDeliverySystem.java class which handles all user input and console interaction.

com.tns.fooddeliverysystem.entities: Holds all the data models (POJOs) like User, Customer, FoodItem, Order, etc.

com.tns.fooddeliverysystem.services: Contains the business logic classes (CustomerService, FoodService, OrderService) that manage the data.
