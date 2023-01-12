package com.example.LMS_db.Service;


import com.example.LMS_db.Enums.CardStatus;
import com.example.LMS_db.Models.Card;
import com.example.LMS_db.Models.Student;
import com.example.LMS_db.Repository.CardRepository;
import com.example.LMS_db.Repository.StudentRepository;
import com.example.LMS_db.RequestDTO.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardService cardService;

    public String createStudent(StudentRequest studentRequest){

        Student student = new Student();
        student.setAge(studentRequest.getAge());
        student.setCountry(studentRequest.getCountry());
        student.setEmail(studentRequest.getEmail());
        student.setName(studentRequest.getName());

        Card newCard = cardService.createCard(student);
        // for that bidirectional relation
        student.setCard(newCard);

        studentRepository.save(student);

        //cardRepository.save() will automatically be taken off because of bidirectional relation

        return "Successfully added student and card";
    }
}
