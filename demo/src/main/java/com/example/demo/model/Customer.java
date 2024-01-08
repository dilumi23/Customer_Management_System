package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customer")
public class Customer {
    @Id
    private String ID;
    private String name;
    private String email;
    private String gender;

    public Customer(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
