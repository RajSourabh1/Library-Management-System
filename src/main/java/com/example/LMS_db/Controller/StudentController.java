package com.example.LMS_db.Controller;


import com.example.LMS_db.RequestDTO.StudentRequest;
import com.example.LMS_db.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody()StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }
}
