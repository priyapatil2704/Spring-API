package com.adapty.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adapty.ecommerce.entities.Product;
import com.adapty.ecommerce.entities.STATUS;
import com.adapty.ecommerce.repository.ProductRepository;

@Service
public class ProductImpl implements ProductInterface{
    //Fetch all products

    @Autowired
    ProductRepository repoObj;
    public List<Product> fetchAllProducts(){
        
        return repoObj.findAll();
    }

    //Fetch product by id
    public Optional<Product> fetchProductById(Product productObj){
        //Optional<Product> ret=repoObj.findById(productObj.getProductId());
        if(productObj.getProductStatus()==STATUS.ACTIVE){
            return repoObj.findById(productObj.getProductId());
        }
        else{
            return null;
        }
       // return repoObj.findById(productId);
    }

    //Adding new product
    public Product addNewProduct(Product productObj){
        repoObj.save(productObj);
        return productObj;
    }

    //Update product
    public Product updateProductById(Product productObj){
        
            Optional<Product> p1=repoObj.findById(productObj.getProductId());
            p1.get().setProductCategory(productObj.getProductCategory());
            p1.get().setProductDescription(productObj.getProductDescription());
            p1.get().setProductImage(productObj.getProductImage());
            p1.get().setProductName(productObj.getProductName());
            p1.get().setProductPrice(productObj.getProductPrice());
            p1.get().setProductStatus(productObj.getProductStatus());
            repoObj.deleteById(productObj.getProductId());
            repoObj.save(p1.get());
            return productObj;
        
    }

    // //Delete a product

    public String deleteProductById(Product productObj){
        if(productObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
        else{
            Optional<Product> d1 =repoObj.findById(productObj.getProductId());
            if(d1.get().getProductStatus() ==STATUS.ACTIVE){
                d1.get().setProductStatus(STATUS.INACTIVE);
                repoObj.save(d1.get());
                return "Object Deleted Successfully";
             
            }
            else{
                return "Object does not exists";
            }
        }
    }

    
    

}
