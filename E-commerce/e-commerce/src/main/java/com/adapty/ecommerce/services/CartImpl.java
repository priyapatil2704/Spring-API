package com.adapty.ecommerce.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adapty.ecommerce.entities.Cart;
import com.adapty.ecommerce.entities.Product;
import com.adapty.ecommerce.entities.STATUS;
import com.adapty.ecommerce.repository.CartRepository;
import com.adapty.ecommerce.repository.ProductRepository;

@Service
public class CartImpl implements CartInterface{
    @Autowired
    ProductRepository prObj;
    @Autowired
    CartRepository repoObj;
    public ArrayList fetchAllProducts() throws NoSuchElementException{
        float totalPrice=0;
        ArrayList list = new ArrayList();
        List<Cart> c1 = repoObj.findAll();
        for(int i = 0; i<c1.size();i++){
            
            Optional<Product> c2 = prObj.findById(c1.get(i).getProductId());
            int c3 = c1.get(i).getCartItemQty();
            totalPrice = totalPrice + (c3*c2.get().getProductPrice()); 
            list.add(Arrays.asList(c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategory(),c2.get().getProductDescription(),c2.get().getProductStatus()));  
            list.add(totalPrice);
            list.add(c1.get(i).getProductId());
            list.add(c1.get(i).getCartItemQty());
            
    }
        return list;
    
    
    // System.out.println(totalPrice);
    // return repoObj.findAll()+totalPrice;
    //return totalPrice;
}

    public Optional<Cart> fetchByCartItemId(String cartItemId){
        return repoObj.findById(cartItemId);
    }

    public String addToCart(Cart cartObj){
        Optional<Product> d1 =prObj.findById(cartObj.getProductId());
        if(d1.isPresent()){
        if(d1.get().getProductStatus() ==STATUS.ACTIVE){
            //d1.get().setProductStatus(STATUS.INACTIVE);
            repoObj.save(cartObj);
           return "Object added";
        }
        else{
            return "Object does not exists";
        }
    }
    else{
        return "product not found";
    }
            // repoObj.save(cartObj);
            // return "Added";
        
      
    }

    //delete product by item id
    public String deleteItemByCartId(String cartItemId){
        repoObj.deleteById(cartItemId);
        return "Deleted item successfully";
    }

    //delete by product id

    public String deleteItemByProductId(String productId){
       
        repoObj.deleteByProductId(productId);
        return "Deleted";
    }

    //update product

    public String updateByCartItemId(Cart cartObj){
        if(cartObj.getCartItemId()==null){
            return null;
        }
        else{
            Optional<Cart> c1=repoObj.findById(cartObj.getCartItemId());
            c1.get().setCartItemQty(cartObj.getCartItemQty());
            c1.get().setProductId(cartObj.getProductId());
            repoObj.deleteById(cartObj.getCartItemId());
            return "Updated successfully";


        }
    }

    // find total price of products
    // public float calculatePriceByProductId(Cart cartObj){
    //     Optional<List<Cart>> p1=repoObj.calculatePriceByProductId(cartObj);
    //     List<Cart> a=p1.get();
    //     float sum=0.0f;
        
    //     if(p1.isPresent()){
    //        for (int i = 0; i < a.size(); i++) {
    //         for (int j = 0; j < a.size(); j++) {
    //              sum=((Cart) p1.get()).getCartItemQty()*((Product) p1.get()).getProductPrice();
    //         }
    //        }
    //        return sum;

    //     }
    //     else{
    //         return 0;
    //     }
    // }
}
