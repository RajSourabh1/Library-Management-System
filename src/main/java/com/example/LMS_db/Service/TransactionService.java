package com.example.LMS_db.Service;

import com.example.LMS_db.Enums.CardStatus;
import com.example.LMS_db.Enums.TransactionStatus;
import com.example.LMS_db.Models.Book;
import com.example.LMS_db.Models.Card;
import com.example.LMS_db.Models.Transaction;
import com.example.LMS_db.Repository.BookRepository;
import com.example.LMS_db.Repository.CardRepository;
import com.example.LMS_db.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${books.max_allowed}")
    public int max_allowed_books;

    @Value("${books.max_allowed_days}")
    public int getMax_allowed_days;

    @Value("${books.fine.per_day}")
    public int fine_per_day;

    public String issueBook(int cardId, int bookId) throws Exception {
    //check whether bookId and cardId already exist
    //conditions required for successful transaction of issue book:
    //1. book is present and available
    // If it fails: throw new Exception("Book is either unavailable or not present");
    //2. card is present and activated
    // If it fails: throw new Exception("Card is invalid");
    //3. number of books issued against the card is strictly less than max_allowed_books
    // If it fails: throw new Exception("Book limit has reached for this card");
    //If the transaction is successful, save the transaction to the list of transactions and return the id

    //Note that the error message should match exactly in all cases

    Card card = cardRepository.findById(cardId).get();
    Book book = bookRepository.findById(bookId).get();

    Transaction transaction = new Transaction();
        transaction.setIssueOperation(true);
        transaction.setBook(book);
        transaction.setCard(card);

        if(book==null || book.isAvailable()==false){
        transaction.setTransactionStatus(TransactionStatus.FAILED);
        transactionRepository.save(transaction);
        throw new Exception("Book is either unavailable or not present");
    }

        if(card == null || card.getCardStatus()== CardStatus.DEACTIVATED){
        transaction.setTransactionStatus(TransactionStatus.FAILED);
        transactionRepository.save(transaction);
        throw new Exception("Card is invalid");
    }

        if(card.getBookIssued().size() >= max_allowed_books){
        transaction.setTransactionStatus(TransactionStatus.FAILED);
        transactionRepository.save(transaction);
        throw new Exception("Book limit has reached for this card");
    }

       // Transaction transaction = new Transaction();

        card.getBookIssued().add(book);
        book.setCard(card);
        book.setAvailable(false);
        book.getTransactions().add(transaction);

       // bookRepository.save(book);
        cardRepository.save(card);

        transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);
        transactionRepository.save(transaction);

        return transaction.getTransactionId(); //return transactionId instead
}

    public Transaction returnBook(int cardId, int bookId) throws Exception{

        List<Transaction> transactionList = transactionRepository.findAll();
        Transaction transaction = null;

        for(Transaction transaction1 : transactionList){

            System.out.println(transaction1.getCard());

            if(transaction1.getCard().getId()==cardId && transaction1.getBook().getId()==bookId && transaction1.getTransactionStatus()==TransactionStatus.SUCCESSFUL && transaction1.isIssueOperation()){
                 transaction = transaction1;
            }
        }

       // List<Transaction> transactions = transactionRepository.find(cardId, bookId, TransactionStatus.SUCCESSFUL, true);
       // Transaction transaction = transactions.get(transactions.size() - 1);

        Date issueDate = transaction.getTransactionDate();
        long timeIssueTime = System.currentTimeMillis()-issueDate.getTime();
        long noOfDaysPassed = TimeUnit.DAYS.convert(timeIssueTime,TimeUnit.MILLISECONDS);

        int fine = 0;
        if(noOfDaysPassed>getMax_allowed_days)
            fine = (int) ((noOfDaysPassed-getMax_allowed_days)*fine_per_day);


        Book book = transaction.getBook();
        book.setAvailable(true);
        book.setCard(null);
        bookRepository.save(book);

        Card card = cardRepository.findById(cardId).get();
        card.getBookIssued().remove(book);
        cardRepository.save(card);

        Transaction tr = new Transaction();
        tr.setTransactionStatus(TransactionStatus.SUCCESSFUL);
        tr.setBook(transaction.getBook());
        tr.setCard(transaction.getCard());
        tr.setIssueOperation(false);
        tr.setFineAmount(fine);

        transactionRepository.save(tr);

        return tr; //return the transaction after updating all details
    }
}
