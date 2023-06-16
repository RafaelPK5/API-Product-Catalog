package com.product.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.Models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
