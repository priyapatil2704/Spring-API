package com.adapty.ecommerce.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.adapty.ecommerce.entities.CATEGORY;
import com.adapty.ecommerce.entities.Product;
import com.adapty.ecommerce.entities.STATUS;
import com.adapty.ecommerce.repository.ProductRepository;
import com.adapty.ecommerce.services.ProductImpl;

@ExtendWith(MockitoExtension.class)
public class TestProductService {
    @InjectMocks
    ProductImpl srvObj;

    @Mock
    ProductRepository productRepoObj;

    @Test
    public void fetchAllProductsTest(){
        List<Product> list1=new LinkedList<Product>();
        Product p1=new Product("M101", "Iphone11", 47999.9f, "Great phone", CATEGORY.MOBILES, "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70", STATUS.ACTIVE);
        Product p2=new Product("F101", "Shirt", 479.9f, "Great shirt", CATEGORY.FASHION, "https://rukminim1.flixcart.com/image/495/594/l0jwbrk0/t-shirt/h/o/f/s-bdgyblrnful-z35-blive-original-imagcbc2pjwagcnq.jpeg?q=50", STATUS.ACTIVE);

        list1.add(p1);
        list1.add(p2);

        when(productRepoObj.findAll()).thenReturn(list1);
        List<Product> productList=srvObj.fetchAllProducts();
        assertEquals(2, productList.size());
        verify(productRepoObj,times(1)).findAll();

    }

    @Test
    public void fetchProductByIdTest(){
        Product p1=new Product("M101", "Iphone11", 47999.9f, "Great phone", CATEGORY.MOBILES, "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70", STATUS.ACTIVE);
        when(productRepoObj.findById("M101")).thenReturn(Optional.of(p1));
        Optional<Product> p=srvObj.fetchProductById(p1);
        assertEquals(p1.getProductId(), p.get().productId);
        //Assertions.assertThat(p.getProductId()).isEqualTo(p1.getProductId());
       // when(productRepoObj.findById(p1.getProductId())).thenReturn(p);
      // assertNotNull(p);
    //  Product pr=productRepoObj.findById(p.).get();
       // Assertions.assertThat(p1.getProductId()).isEqualTo(p);
      // assertEquals("M101", p);
       // verify(productRepoObj,times(1)).findById(p1.getProductId());
    }

    @Test
    public void deleteProductByIdTest(){
        Product p1=new Product("M101", "Iphone11", 47999.9f, "Great phone", CATEGORY.MOBILES, "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70", STATUS.ACTIVE);
        when(productRepoObj.findById("M101")).thenReturn(Optional.of(p1));
        String msg=srvObj.deleteProductById(p1);
        assertEquals("Object Deleted Successfully", msg);
    }

    @Test
    public void addNewProductTest(){
        Product p1=new Product("M101", "Iphone11", 47999.9f, "Great phone", CATEGORY.MOBILES, "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70", STATUS.ACTIVE);
        when(productRepoObj.save(p1)).thenReturn(p1);
        Product p2=srvObj.addNewProduct(p1);
        assertNotNull(p2,"Object created");
    }

    @Test
    public void updateProductByIdTest(){
         Product p1=new Product("E101", "Iphone11", 47999.9f, "Great phone", CATEGORY.MOBILES, "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70", STATUS.ACTIVE);
        
       

        p1.setProductPrice(1000);
       // Product p=productRepoObj.findById("101").get();
       // pro.setProductPrice(1000);
       // productRepoObj.save(p);
      //  Product p2=srvObj.fetchProductById(p1).get();
        //p2.setProductPrice(1000);
        Assertions.assertThat(p1.getProductPrice()).isEqualTo(1000);
        
}
}
