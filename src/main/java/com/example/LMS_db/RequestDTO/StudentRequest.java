package com.example.LMS_db.RequestDTO;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class StudentRequest {

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String country;
}
