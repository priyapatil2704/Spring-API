package com.adapty.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adapty.ecommerce.entities.Cart;
import com.adapty.ecommerce.entities.Product;
import com.adapty.ecommerce.services.CartImpl;

import lombok.Value;


@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartImpl srvObj;
    @GetMapping(value = "")
    public ArrayList fetchAllProducts(){
        return srvObj.fetchAllProducts();
    }

    @GetMapping(value="/{cartItemId}")
    public Optional<Cart> fetchByCartItemId(@PathVariable("cartItemId") String cartItemId){
        return srvObj.fetchByCartItemId(cartItemId);
    }

    @PostMapping(value="/add")
    public String addToCart(@RequestBody Cart cartObj){
        return srvObj.addToCart(cartObj);
    }

    @DeleteMapping(value="/del/{cartItemId}")
    public String deleteItemByCartId(@PathVariable("cartItemId") String cartItemId){
        return srvObj.deleteItemByCartId(cartItemId);
    }

    @DeleteMapping(value = "/del/item/{productId}")
    public String deleteItemByProductId(@PathVariable("productId") String productId){
        return srvObj.deleteItemByProductId(productId);
    }
    @PutMapping(value="/update")
    public String updateByCartItemId(@RequestBody Cart cartObj){
        return srvObj.updateByCartItemId(cartObj);
    }
    // @GetMapping(value="/price")
    // public float calculateProductPriceByProductId(Cart cartObj){
    //     return srvObj.calculatePriceByProductId(cartObj);
    // }
}
