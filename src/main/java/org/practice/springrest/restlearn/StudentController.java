package org.practice.springrest.restlearn;

import org.practice.springrest.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/get")
    public Student getStudent(){
        Student student = new Student(1,"Harsha","Bengaluru");
        return student;
    }
    @PostMapping("/post")
    public String postStudent(@RequestBody Student student){
        System.out.println(student);
        return "Data Saved";
    }

}
