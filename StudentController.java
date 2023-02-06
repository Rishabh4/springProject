package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentservice;
    

    @RequestMapping("/students")
    
     public List<Student> getAllStudents(){
        return studentservice.studentlist();
        
     }
     @RequestMapping("/students/{id}")
     public Optional<Student> getStudentbyId(@PathVariable Integer id){
        return studentservice.getstudentbyid(id);
     }

     @PostMapping("/students")
     public void postStudent(@RequestBody Student student){
        studentservice.putstudent(student);
     }

     @DeleteMapping("/students/{id}")
     public void deleteStudentbyId(@PathVariable Integer id){
        studentservice.deletestudentbyid(id);
     }
     
    
}
