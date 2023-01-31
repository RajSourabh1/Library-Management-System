package com.example.LMS_db.Controller;

import com.example.LMS_db.RequestDTO.BookRequest;
import com.example.LMS_db.ResponseDTO.BookResponse;
import com.example.LMS_db.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody() BookRequest bookRequest){
        return bookService.addBook(bookRequest);
    }

    @GetMapping("/getAllBooks")
    public List<BookResponse> getBook(){
        return bookService.getBookNameGenreAuthor();
    }
}
