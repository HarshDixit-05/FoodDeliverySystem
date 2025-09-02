package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.Order;
import java.util.ArrayList;
import java.util.List; 

public class OrderService {
	 private List<Order> orders = new ArrayList<>();
	    private List<DeliveryPerson> deliveryPersons = new ArrayList<>();

	    public void placeOrder(Order order) {
	        orders.add(order);
	    }

	    public List<Order> getOrders() {
	        return orders;
	    }

	    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
	        deliveryPersons.add(deliveryPerson);
	    }

	    public List<DeliveryPerson> getDeliveryPersons() {
	        return deliveryPersons;
	    }

	    /**
	     * Assigns an available delivery person to a specific order.
	     * @param orderId The ID of the order.
	     * @param deliveryPersonId The ID of the delivery person.
	     */
	    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
	        Order orderToUpdate = null;
	        for (Order order : orders) {
	            if (order.getOrderId() == orderId) {
	                orderToUpdate = order;
	                break;
	            }
	        }

	        DeliveryPerson assignedPerson = null;
	        for (DeliveryPerson person : deliveryPersons) {
	            if (person.getDeliveryPersonId() == deliveryPersonId) {
	                assignedPerson = person;
	                break;
	            }
	        }

	        if (orderToUpdate != null && assignedPerson != null) {
	            orderToUpdate.setDeliveryPerson(assignedPerson);
	            orderToUpdate.setStatus("Out for Delivery"); // Update status
	            System.out.println("Delivery person assigned to order successfully!");
	        } else {
	            System.out.println("Error: Invalid Order ID or Delivery Person ID.");
	        }
	    }
}
