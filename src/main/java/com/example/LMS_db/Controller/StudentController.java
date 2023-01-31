package com.example.LMS_db.Controller;


import com.example.LMS_db.Models.Student;
import com.example.LMS_db.RequestDTO.StudentRequest;
import com.example.LMS_db.RequestDTO.UpdateStudent;
import com.example.LMS_db.ResponseDTO.StudentResponse;
import com.example.LMS_db.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody()StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("getById")
    public ResponseEntity<StudentResponse> getStudentById(@RequestParam("id") int id){
        StudentResponse student = studentService.getDetailsById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/updateStudent'sAge")
    public ResponseEntity updateStudent(@RequestBody UpdateStudent updateStudent){
        studentService.updateStudent(updateStudent);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }
}
