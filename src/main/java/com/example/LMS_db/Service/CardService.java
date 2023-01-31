package com.example.LMS_db.Service;

import com.example.LMS_db.Enums.CardStatus;
import com.example.LMS_db.Models.Card;
import com.example.LMS_db.Models.Student;
import com.example.LMS_db.Repository.CardRepository;
import com.example.LMS_db.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    StudentRepository studentRepository;

    public Card createCard(Student student){
        Card newCard = new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);
        newCard.setStudent(student);

        return newCard;
    }
//    public void deactivateCard(int student_id){
//     //   CardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
//        Student student = studentRepository.findById(student_id).get();
//
//        Card card = student.getCard();
//        card.setCardStatus(CardStatus.DEACTIVATED);
//        card.setStudent(null);
//    }
}
