package com.example.demo.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class Category {
    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3,message = "ID must be more than 3 Characters long")
    private String id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3,message = "Name should be more than 3 character long")
    private String name;
}
