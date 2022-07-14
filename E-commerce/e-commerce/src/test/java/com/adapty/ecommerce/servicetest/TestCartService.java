package com.adapty.ecommerce.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.CrudRepository;

import com.adapty.ecommerce.controllers.CartController;
import com.adapty.ecommerce.entities.Cart;
import com.adapty.ecommerce.repository.CartRepository;
import com.adapty.ecommerce.services.CartImpl;


@ExtendWith(MockitoExtension.class)
public class TestCartService {
    @InjectMocks
    CartImpl cartSrvObj;
    @Mock
    CartRepository cartRepoObj;
 

    @Test
    public void fetchAllProductsTest(){
        List<Cart> list1=new LinkedList<Cart>();
        Cart c1=new Cart("C101", 2, "M101");
        Cart c2=new Cart("C102", 4, "E101");

        list1.add(c1);
        list1.add(c2);

        when(cartRepoObj.findAll()).thenReturn(list1);
        List<Cart> cartList=cartRepoObj.findAll();
        assertEquals(2, cartList.size());
         verify(cartRepoObj,times(1)).findAll();
    }

    @Test
    public void fetchByCartIdTest(){
        Cart c1=new Cart("C101", 2, "M101");
        when(cartRepoObj.findById("C101")).thenReturn(Optional.of(c1));
        Optional<Cart> p=cartSrvObj.fetchByCartItemId(c1.getCartItemId());
        assertEquals(c1.getCartItemId(), p.get().cartItemId);
    }

    @Test
    public void deleteByCartIdTest(){
        Cart c1=new Cart("C101", 2, "M101");
       // when(cartRepoObj.findById("C101")).thenReturn(Optional.of(c1));
        String msg=cartSrvObj.deleteItemByCartId(c1.getCartItemId());
        assertEquals("Deleted item successfully", msg);
    }

    @Test
    public void addToCartTet(){
        Cart c1=new Cart("C101", 2, "M101");
    
    cartRepoObj.save(c1);
    verify(cartRepoObj,times(1)).save(c1);
    }

    @Test
    public void updateProductByIdTest(){
        Cart c1=new Cart("C101", 2, "M101");
    
        c1.setCartItemQty(4);


         Assertions.assertThat(c1.getCartItemQty()).isEqualTo(4);
        }

        @Test
        public void deleteItemByProductId(){
          Cart c1=new Cart("C101", 2, "M101");
      
          String msg=cartSrvObj.deleteItemByProductId(c1.getProductId());
          assertEquals("Deleted", msg);
      }
}
