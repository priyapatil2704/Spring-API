package com.adapty.ecommerce.repository;


import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.adapty.ecommerce.entities.Cart;
import com.adapty.ecommerce.services.CartImpl;

public interface CartRepository extends JpaRepository<Cart,String>{
  
    @Transactional
    //@Query(value = "delete from cart where product_id=E101 and cart_item_id=190",nativeQuery=true) 
    public Optional<String> deleteByProductId(String productId);
    //public Optional<List<Cart>> calculatePriceByProductId(Cart cartObj);
}
