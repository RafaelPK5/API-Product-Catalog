package com.product.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.Models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
