package com.example.customerapi;

import java.util.List;

public class Customer {

    private int cust_id;
    private String cust_name;
    private String cust_contact;
    private List<CartItem> cart;

    public Customer() {
    }

    public Customer(int cust_id, String cust_name, String cust_contact,
                    List<CartItem> cart) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_contact = cust_contact;
        this.cart = cart;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_contact() {
        return cust_contact;
    }

    public void setCust_contact(String cust_contact) {
        this.cust_contact = cust_contact;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }
}
