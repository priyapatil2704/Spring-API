package com.adapty.ecommerce.repository;

import com.adapty.ecommerce.entities.Product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,String>{



    
    
}
