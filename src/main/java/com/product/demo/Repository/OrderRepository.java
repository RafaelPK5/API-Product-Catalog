package com.product.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.Models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
