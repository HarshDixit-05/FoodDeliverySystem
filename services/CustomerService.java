package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.Customer;
import java.util.ArrayList;
import java.util.List;
public class CustomerService {
	private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    /**
     * Retrieves a customer by their user ID.
     * @param userId The ID of the customer to find.
     * @return The Customer object if found, otherwise null.
     */
    public Customer getCustomer(int userId) {
        for (Customer customer : customerList) {
            if (customer.getUserId() == userId) {
                return customer;
            }
        }
        return null; // Return null if customer not found
    }

    public List<Customer> getCustomers() {
        return customerList;
    }
}
