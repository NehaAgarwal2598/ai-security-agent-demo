package com.example.ordersapp.controller;

import com.example.ordersapp.model.Order;
import com.example.ordersapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/search")
    public List<Order> searchByCustomer(@RequestParam String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }
}
