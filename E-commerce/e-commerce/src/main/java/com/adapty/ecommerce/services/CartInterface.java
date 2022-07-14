package com.adapty.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.adapty.ecommerce.entities.Cart;
import com.adapty.ecommerce.entities.Product;

public interface CartInterface {
    public ArrayList fetchAllProducts();
    public Optional<Cart> fetchByCartItemId(String cartItemId);
    public String addToCart(Cart cartObj);
    public String deleteItemByCartId(String cartItemId);
    public String deleteItemByProductId(String productId);

    //public float calculatePriceByProductId(Cart cartObj);


}
