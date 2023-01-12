package com.example.LMS_db.Controller;

import com.example.LMS_db.RequestDTO.BookRequest;
import com.example.LMS_db.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody() BookRequest bookRequest){
        return bookService.addBook(bookRequest);
    }
}
