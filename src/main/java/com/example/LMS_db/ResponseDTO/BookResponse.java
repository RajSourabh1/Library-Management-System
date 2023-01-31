package com.example.LMS_db.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookResponse {

    String name;
    String genre;
    String author;
}
