package com.example.demo.Controller;

import com.example.demo.Modele.Api;
import com.example.demo.Modele.Merchant;
import com.example.demo.Service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getMerchants(){
        return ResponseEntity.status(200).body((merchantService.getMerchants()));
    }
    @PostMapping("/add")
    public ResponseEntity<Api> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!merchantService.addMerchants(merchant)){
            return ResponseEntity.status(500).body(new Api("Server error adding a Merchant",500));
        }
        return ResponseEntity.status(200).body(new Api("Merchant added successfully",200));
    }
    @PutMapping("/update")
    public ResponseEntity<Api> updateMerchant(@RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(merchantService.updateMerchants(merchant)){
            return ResponseEntity.status(200).body(new Api("Merchant updated",200));
        }
        return ResponseEntity.status(400).body(new Api("Merchant not found",400));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Api> deleteMerchant(@PathVariable String id){
        if(merchantService.deleteMerchant(id)){
            return ResponseEntity.status(200).body(new Api("Merchant deleted",200));
        }
        return ResponseEntity.status(400).body(new Api("Merchant not found",400));
    }
    @PutMapping("/addstock/{merchantID}/{productID}/{stock}")
    public  ResponseEntity<Api> addStock(@PathVariable String merchantID,@PathVariable String productID,@PathVariable Integer stock){
        Integer stockStatus =  merchantService.addStock(merchantID,productID,stock);
        switch (stockStatus){
            case -1:{
                return ResponseEntity.status(400).body(new Api("Merchant not found",400));
            }
            case 0:
                return ResponseEntity.status(400).body(new Api("Product not found",400));
            case 1:
                return ResponseEntity.status(200).body(new Api("Stock updated",200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error",500));
        }

    }

}