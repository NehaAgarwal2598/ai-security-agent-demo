package com.example.ordersapp.model;

public class Order {

    private Long id;
    private String customerName;
    private double total;

    public Order() {}

    public Order(String customerName, double total) {
        this.customerName = customerName;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
