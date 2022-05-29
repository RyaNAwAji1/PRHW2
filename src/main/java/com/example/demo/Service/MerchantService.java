package com.example.demo.Service;

import com.example.demo.Modele.Merchant;
import com.example.demo.Modele.MerchantStock;
import com.example.demo.Modele.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantService {
    ArrayList<Merchant> merchants = new ArrayList<>();
    private final MerchantStockService merchantStockService;
    private final ProductService productService;

    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    public boolean addMerchants(Merchant merchant){
        merchants.add(merchant);
        return true;
    }

    public boolean updateMerchants(Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if (merchant.getId().equals(merchants.get(i).getId()))
                merchants.set(i,merchant);
            return true;
        }
        return false;
    }
    public boolean deleteMerchant(String id){
        if(finMerchantByID(id) == null){
            return false;
        }
        merchants.remove(finMerchantByID(id));
        return true;
    }

    public Merchant finMerchantByID(String id){
        for (Merchant merchant:merchants) {
            if(id.equals(merchant.getId())){
                return merchant;
            }
        }
        return null;
    }
    public Integer addStock(String merchantID,String productID,Integer stock){
        MerchantStock merchantStock = merchantStockService.finMerchantStockByID(merchantID);
        if(merchantStock == null){
            return -1;
        }
        Product product = productService.findProductByID(productID);
        if(product == null){
            return 0;
        }
        merchantStock.setStock(merchantStock.getStock()+stock);
        return 1;
    }
}
