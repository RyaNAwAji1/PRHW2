package com.example.demo.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class PurchaseHistory {
    @NotEmpty(message = "id is required") @Size(max = 3)
    private String id;
    @NotEmpty(message = "id is required") @Size(max = 3)
    private String userId;
    @NotEmpty(message = "id is required") @Size(max = 3)
    private String productid;
    @NotEmpty(message = "id is required")
    private String price;

}
