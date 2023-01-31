package com.example.LMS_db.Controller;

import com.example.LMS_db.Models.Author;
import com.example.LMS_db.RequestDTO.AuthorRequest;
import com.example.LMS_db.ResponseDTO.AuthorResponse;
import com.example.LMS_db.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/create")
    public String addAuthor(@RequestBody()AuthorRequest authorRequest){
      return authorService.addAuthor(authorRequest);
    }

    @GetMapping("/findBy/{name}")
    public List<AuthorResponse> findByName(@PathVariable("name")String name){
        return authorService.finAuthorByName(name);
    }
}
