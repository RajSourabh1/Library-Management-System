package com.example.LMS_db.RequestDTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequest {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false,unique = true)
    private String email;

}
