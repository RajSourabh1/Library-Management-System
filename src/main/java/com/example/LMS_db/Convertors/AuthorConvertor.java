package com.example.LMS_db.Convertors;

import com.example.LMS_db.Models.Author;
import com.example.LMS_db.Models.Book;
import com.example.LMS_db.RequestDTO.AuthorRequest;
import com.example.LMS_db.ResponseDTO.AuthorResponse;
import com.example.LMS_db.ResponseDTO.BookResponse;

import java.util.ArrayList;
import java.util.List;

public class AuthorConvertor {

    public static Author convertDtoToEntity(AuthorRequest authorRequest){

        Author author = Author.builder().
                                         name(authorRequest.getName())
                                        .age(authorRequest.getAge())
                                        .country(authorRequest.getCountry())
                                        .email(authorRequest.getEmail()).build();
        return author;
    }

    public static List<AuthorResponse> convertEntityToDTO(List<Author> authors){

        List<AuthorResponse> authorResponseList = new ArrayList<>();

        for(Author author : authors){
            AuthorResponse authorResponse = AuthorResponse.builder()
                                            .name(author.getName())
                                            .age(author.getAge())
                                            .country(author.getCountry())
                                            .email(author.getEmail()).build();
            authorResponseList.add(authorResponse);

            // try yourself on how to add BookResponse

        }
        return authorResponseList;
    }
}
