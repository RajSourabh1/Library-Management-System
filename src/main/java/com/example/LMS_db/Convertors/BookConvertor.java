package com.example.LMS_db.Convertors;

import com.example.LMS_db.Models.Book;
import com.example.LMS_db.RequestDTO.BookRequest;
import com.example.LMS_db.ResponseDTO.BookResponse;

import java.util.List;

public class BookConvertor {

    public static Book convertDtoToEntity(BookRequest bookRequest) {

        Book book = Book.builder().
                                   name(bookRequest.getName())
                                  .genre(bookRequest.getGenre()).build();
        return book;
    }

}
