package com.adapty.ecommerce.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




 @Entity
public class Product {
    @Id
    @Column(name = "productId")
    public String productId;
    public String productName;
    public float productPrice;
    public String productDescription;
    @Enumerated(EnumType.STRING)
    CATEGORY productCategory;
    public String productImage;
    @Enumerated(EnumType.STRING)
    STATUS productStatus;

    @OneToMany
    @JoinColumn(name="productId",referencedColumnName="productId")
    private List<Cart> cart=new LinkedList<>();
   
    public Product(){
       
    }
    public Product(String productId, String productName, float productPrice, String productDescription, 
    CATEGORY productCategory, String productImage, STATUS productStatus
    ) {
       
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productImage = productImage;
        this.productStatus = productStatus;
        
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public CATEGORY getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(CATEGORY productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public STATUS getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(STATUS productStatus) {
        this.productStatus = productStatus;
    }

    
    @Override
    public String toString() {
        return "{" +
            " productId='" + getProductId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            ", productDescription='" + getProductDescription() + "'" +
            ", productCategory='" + getProductCategory() + "'" +
            ", productImage='" + getProductImage() + "'" +
            ", productStatus='" + getProductStatus() + "'" +
            "}";
    }

}
