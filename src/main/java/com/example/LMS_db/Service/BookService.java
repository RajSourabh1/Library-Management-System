package com.example.LMS_db.Service;

import com.example.LMS_db.Convertors.BookConvertor;
import com.example.LMS_db.Models.Author;
import com.example.LMS_db.Models.Book;
import com.example.LMS_db.Repository.AuthorRepository;
import com.example.LMS_db.Repository.BookRepository;
import com.example.LMS_db.RequestDTO.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public String addBook(BookRequest bookRequest){
        Book book = BookConvertor.convertDtoToEntity(bookRequest);

        // I need to set the AuthorEntity
        int authorId = bookRequest.getAuthorId();
        Author author = authorRepository.findById(authorId).get();

        book.setAuthor(author);

        // then book list also need to be updated
        List<Book> currentListOfBook = author.getBookWrittenByAuthor();
        currentListOfBook.add(book);
        author.setBookWrittenByAuthor(currentListOfBook);

        //save the author
        authorRepository.save(author);

        // save the book
       // bookRepository.save(book);  this function will automatically be called by the parent save function

        return "Successfully book added";
    }
}
