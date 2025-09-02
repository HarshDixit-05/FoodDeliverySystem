package com.tns.fooddeliverysystem.entities;

// Imports added for Map and HashMap
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a customer's order.
 */
public class Order {
    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>(customer.getCart().getItems());
        this.status = "Pending";
        this.deliveryPerson = null;
    }
    
    // Getters
    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Map<FoodItem, Integer> getItems() { return items; }
    public String getStatus() { return status; }
    public DeliveryPerson getDeliveryPerson() { return deliveryPerson; }
    public String getDeliveryAddress() { return deliveryAddress; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setDeliveryPerson(DeliveryPerson deliveryPerson) { this.deliveryPerson = deliveryPerson; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    
    @Override
    public String toString() {
        String deliveryPersonName = (deliveryPerson != null) ? deliveryPerson.getName() : "Not Assigned";
        return String.format("Order{orderId=%d, customer=%s, items=%s, status='%s', deliveryPerson=%s}",
                orderId, customer.getUsername(), items, status, deliveryPersonName);
    }
}