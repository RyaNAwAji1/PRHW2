package com.example.demo.Modele;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {
    @NotEmpty(message = "id is required") @Size(max = 3)
    private String id;
    @NotEmpty(message = "id is required") @Size(max = 4)
    private String userid;

    private ArrayList<Product> product;

    public Cart(String id, String userid, ArrayList<Product> product) {
        this.id = id;
        this.userid = userid;
        this.product = new ArrayList <>();
    }
}
