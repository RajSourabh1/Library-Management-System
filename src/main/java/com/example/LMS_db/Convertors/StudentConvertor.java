package com.example.LMS_db.Convertors;

import com.example.LMS_db.Models.Author;
import com.example.LMS_db.Models.Student;
import com.example.LMS_db.RequestDTO.StudentRequest;
import com.example.LMS_db.ResponseDTO.AuthorResponse;
import com.example.LMS_db.ResponseDTO.StudentResponse;

import java.util.ArrayList;
import java.util.List;

public class StudentConvertor {

    public static Student convertDtoToEntity(StudentRequest studentRequest){

        Student student = Student.builder().
                name(studentRequest.getName())
                .age(studentRequest.getAge())
                .country(studentRequest.getCountry())
                .email(studentRequest.getEmail()).build();
        return student;
    }

    public static StudentResponse convertEntityToDTO(Student student){

            StudentResponse studentResponse = StudentResponse.builder()
                    .name(student.getName())
                    .age(student.getAge())
                    .country(student.getCountry())
                    .email(student.getEmail()).build();

        return studentResponse;
    }
}
