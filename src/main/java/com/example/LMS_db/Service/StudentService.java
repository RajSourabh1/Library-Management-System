package com.example.LMS_db.Service;


import com.example.LMS_db.Convertors.StudentConvertor;
import com.example.LMS_db.Enums.CardStatus;
import com.example.LMS_db.Models.Card;
import com.example.LMS_db.Models.Student;
import com.example.LMS_db.Repository.CardRepository;
import com.example.LMS_db.Repository.StudentRepository;
import com.example.LMS_db.RequestDTO.StudentRequest;
import com.example.LMS_db.RequestDTO.UpdateStudent;
import com.example.LMS_db.ResponseDTO.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardService cardService;

    public String createStudent(StudentRequest studentRequest){

        Student student = StudentConvertor.convertDtoToEntity(studentRequest);

        Card newCard = cardService.createCard(student);
        // for that bidirectional relation
        student.setCard(newCard);

        studentRepository.save(student);

        //cardRepository.save() will automatically be taken off because of bidirectional relation

        return "Successfully added student and card";
    }

    public StudentResponse getDetailsById(int id){
        Student student = studentRepository.findById(id).get();

        StudentResponse studentResponse = StudentConvertor.convertEntityToDTO(student);
        return studentResponse;
    }

    public void updateStudent(UpdateStudent updateStudent){
        Student updatedStudent = studentRepository.findById(updateStudent.getId()).get();
        updatedStudent.setAge(updateStudent.getAge());
        studentRepository.save(updatedStudent);
    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
       // cardService.deactivateCard(id);
        studentRepository.deleteById(id);
    }
}
