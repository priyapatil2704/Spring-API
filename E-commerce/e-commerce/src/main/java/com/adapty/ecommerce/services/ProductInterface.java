package com.adapty.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.adapty.ecommerce.entities.Product;

public interface ProductInterface {
    public List<Product> fetchAllProducts();
    public Optional<Product> fetchProductById(Product productObj);
    public Product addNewProduct(Product productObj);
    public Product updateProductById(Product productObj);
    public String deleteProductById(Product productobj);

}
