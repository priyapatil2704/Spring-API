package com.adapty.ecommerce.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




    @Entity(name = "cart")
    public class Cart {
    @Id
    public String cartItemId;
    public int cartItemQty;

    @Column(name = "productId",nullable = false,insertable = true,updatable = true)

    public String productId;
    public Cart() {
        
    }

    

    public Cart(String cartItemId, int cartItemQty, String productId) {
        super();
        this.cartItemId = cartItemId;
        this.cartItemQty = cartItemQty;
        this.productId=productId;
    }


   

    public String getCartItemId() {
        return this.cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartItemQty() {
        return this.cartItemQty;
    }

    public void setCartItemQty(int cartItemQty) {
        this.cartItemQty = cartItemQty;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    

    @Override
    public String toString() {
        return "{" +
            " cartItemId='" + getCartItemId() + "'" +
            ", cartItemQty='" + getCartItemQty() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }



    // public String getProductId() {
    //     return null;
    // }

   
    
    
}






    

