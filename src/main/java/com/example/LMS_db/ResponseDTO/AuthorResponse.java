package com.example.LMS_db.ResponseDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AuthorResponse {

    private String name;

    private int age;

    private String country;

    private String email;

}
