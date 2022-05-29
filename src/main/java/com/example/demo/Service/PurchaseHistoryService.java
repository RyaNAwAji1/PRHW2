package com.example.demo.Service;

import com.example.demo.Modele.PurchaseHistory;
import org.springframework.stereotype.Service;
import com.example.demo.Modele.Cart;

import java.util.ArrayList;

@Service
public class PurchaseHistoryService {
    ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<>();

    public ArrayList<PurchaseHistory> getPurchaseHistories(){
        return purchaseHistories;
    }
    public boolean addPurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistories.add(purchaseHistory);
        return true;
    }
    public boolean checkUserProducts(String userID,String productID){
        for(int i = 0; i < purchaseHistories.size(); i++){
            if(purchaseHistories.get(i).getUserID().equals(userID) && purchaseHistories.get(i).getProductID().equals(productID)){
                return true;
            }
        }
        return false;
    }
}