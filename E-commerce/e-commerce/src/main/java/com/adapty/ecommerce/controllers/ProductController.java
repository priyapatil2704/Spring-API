package com.adapty.ecommerce.controllers;

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

import com.adapty.ecommerce.entities.Product;
import com.adapty.ecommerce.services.ProductImpl;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductImpl srvObj;
    @GetMapping(value = "")
    public List<Product> fetchAllProducts(){
        return srvObj.fetchAllProducts();
    }

    @GetMapping(value="/{id}")
    public Optional<Product> fetchProductById(@PathVariable("id") Product productObj) {
        return srvObj.fetchProductById(productObj);
    }

    @PostMapping(value = "/add/")
    public Product addNewProduct(@RequestBody Product productObj){
        return srvObj.addNewProduct(productObj);
    }

    @PutMapping(value="")
    public Product updateProductById(@RequestBody Product productObj){
        return srvObj.updateProductById(productObj);
    }

    @DeleteMapping(value = "{id}")
    public String deleteProductById(@PathVariable("id") Product productObj){
        return srvObj.deleteProductById(productObj);
    }
}
