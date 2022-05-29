package com.example.demo.Service;

import com.example.demo.Modele.Cart;
import org.springframework.stereotype.Service;
import com.example.demo.Modele.Category;
import com.example.demo.Modele.User;

import java.util.ArrayList;

@Service
public class CartService {
    private ArrayList<Cart> carts = new ArrayList<>();

    public ArrayList<Cart> getCarts(){
        return carts;
    }
    public boolean addCart(Cart cart){
        carts.add(cart);
        return true;
    }
    public Cart findCartByID(String id){
        for (Cart cart:carts) {
            if(id.equals(cart.getId())){
                return cart;
            }
        }
        return null;
    }
}