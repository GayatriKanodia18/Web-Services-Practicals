package com.example.customerapi;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    public CustomerController() {

        customers.add(new Customer(
                1,
                "Rahul Sharma",
                "9876543210",
                Arrays.asList(
                        new CartItem(101, "Laptop"),
                        new CartItem(102, "Mouse")
                )
        ));

        customers.add(new Customer(
                2,
                "Priya Patel",
                "9876543211",
                Arrays.asList(
                        new CartItem(103, "Keyboard"),
                        new CartItem(104, "Monitor")
                )
        ));

        customers.add(new Customer(
                3,
                "Amit Shah",
                "9876543212",
                Arrays.asList(
                        new CartItem(105, "Headphones")
                )
        ));

        customers.add(new Customer(
                4,
                "Neha Mehta",
                "9876543213",
                Arrays.asList(
                        new CartItem(106, "Mobile Phone")
                )
        ));
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // GET CUSTOMER BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {

        for (Customer customer : customers) {
            if (customer.getCust_id() == id) {
                return customer;
            }
        }

        return null;
    }

    // ADD CUSTOMER
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // UPDATE CUSTOMER
    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable int id,
            @RequestBody Customer updatedCustomer) {

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getCust_id() == id) {
                customers.set(i, updatedCustomer);
                return updatedCustomer;
            }
        }

        return null;
    }

    // DELETE CUSTOMER
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getCust_id() == id) {
                customers.remove(i);
                return "Customer record deleted successfully";
            }
        }

        return "Customer not found";
    }
}
