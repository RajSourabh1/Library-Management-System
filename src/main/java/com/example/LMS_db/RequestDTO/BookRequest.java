package com.example.LMS_db.RequestDTO;

import com.example.LMS_db.Enums.Genre;
import lombok.Data;

@Data
public class BookRequest {

    private String name;

    private Genre genre;

    private int authorId;
}
