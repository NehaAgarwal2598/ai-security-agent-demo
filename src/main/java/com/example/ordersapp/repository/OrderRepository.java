package com.example.ordersapp.repository;

import com.example.ordersapp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Order order) {
        String sql = "INSERT INTO orders (customer_name, total) VALUES ('"
                + order.getCustomerName() + "', " + order.getTotal() + ")";
        jdbcTemplate.execute(sql);
    }

    public List<Order> findByCustomerName(String customerName) {
        String sql = "SELECT id, customer_name, total FROM orders WHERE customer_name = '"
                + customerName + "'";
        return jdbcTemplate.query(sql, (rs, i) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setTotal(rs.getDouble("total"));
            return order;
        });
    }
}
