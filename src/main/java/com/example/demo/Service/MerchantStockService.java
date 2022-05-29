package com.example.demo.Service;

import com.example.demo.Modele.MerchantStock;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MerchantStockService {
    private ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }

    public boolean addMerchantStocks(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);
        return true;
    }

    public boolean updateMerchantStocks(MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStock.getId().equals(merchantStocks.get(i).getId()))
                merchantStocks.set(i,merchantStock);
            return true;
        }
        return false;
    }
    public boolean deleteMerchantStock(String id){
        if(finMerchantStockByID(id) == null){
            return false;
        }
        merchantStocks.remove(finMerchantStockByID(id));
        return true;
    }

    public MerchantStock finMerchantStockByID(String id){
        for (MerchantStock merchantStock:merchantStocks) {
            if(id.equals(merchantStock.getMerchantID())){
                return merchantStock;
            }
        }
        return null;
    }
    public MerchantStock finMerchantStockByProductID(String id){
        for (MerchantStock merchantStock:merchantStocks) {
            if(id.equals(merchantStock.getProductID())){
                return merchantStock;
            }
        }
        return null;
    }

}