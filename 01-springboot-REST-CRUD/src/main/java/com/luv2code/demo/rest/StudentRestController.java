package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;


    //postconstact
    @PostConstruct
    public void loadData()
    {
       theStudents = new ArrayList<>();

        theStudents.add(new Student("Mathan", "Mohan"));
        theStudents.add(new Student("Sri", "Ram"));
        theStudents.add(new Student("Hari", "Haran"));
    }


    //define endpoints
    @GetMapping("/students")
    public List<Student> getStudent() {


        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){


        if( studentId>=theStudents.size() || studentId< 0){
            throw new StudentNotFoundException("Student Not Found - "+studentId);
        }
        return theStudents.get(studentId);
    }



    //Add exception handleer


}






















