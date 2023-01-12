package com.example.LMS_db.Service;

import com.example.LMS_db.Convertors.AuthorConvertor;
import com.example.LMS_db.Models.Author;
import com.example.LMS_db.Repository.AuthorRepository;
import com.example.LMS_db.RequestDTO.AuthorRequest;
import com.example.LMS_db.ResponseDTO.AuthorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(AuthorRequest authorRequest){

        try{
            Author author = AuthorConvertor.convertDtoToEntity(authorRequest);
            authorRepository.save(author);
        }
        catch(Exception e){
            log.info("addAuthor has caused an error");
            return "Add author didn't work";
        }
        return "Author added successfully";
    }

    public List<AuthorResponse> finAuthorByName(String name){
        List<Author> authors = authorRepository.findByName(name);

        List<AuthorResponse> authorResponses = AuthorConvertor.convertEntityToDTO(authors);

        return authorResponses;
    }
}
