package com.example.demo.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Comment {
    @NotEmpty(message = "id is required") @Size(max = 3)
    private String id;
    @NotEmpty(message = "id is required") @Size(max = 3)
    private String userId;
    @NotEmpty(message = "id is required") @Length(max = 6)
    private String message;
    @NotEmpty(message = "id is required") @Range(min = 1,max = 5)
    private String rate;
}
