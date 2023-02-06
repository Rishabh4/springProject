package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentrepository;


     List<Student> students = new ArrayList<>();
    public List<Student> studentlist(){
        for(Student stud:studentrepository.findAll()){
            students.add(stud);
        }
         
        
        return students;
    }
    public Optional<Student> getstudentbyid(Integer id){
        /*Student st=null;
        for(Student stud : students){
            if(stud.getId()==id){
                st=stud;
                break;
            }
        }
        return st;*/
        Optional<Student> stud = studentrepository.findById(id);
        return stud ;

        
    }
    public void putstudent(Student stud){
        /*students.add(stud);
        return stud;*/
        studentrepository.save(stud);
    }
    
    public void deletestudentbyid(Integer id){
        /*Student st=null;
        for(Student stud : students){
            if(stud.getId()==id){
                st=stud;
                break;
            }
        }
        students.remove(st);
        return students;*/
        studentrepository.deleteById(id);
    }
    
}
