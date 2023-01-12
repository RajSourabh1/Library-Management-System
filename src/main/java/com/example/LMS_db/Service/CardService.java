package com.example.LMS_db.Service;

import com.example.LMS_db.Enums.CardStatus;
import com.example.LMS_db.Models.Card;
import com.example.LMS_db.Models.Student;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    public Card createCard(Student student){
        Card newCard = new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);
        newCard.setStudent(student);

        return newCard;
    }
}
