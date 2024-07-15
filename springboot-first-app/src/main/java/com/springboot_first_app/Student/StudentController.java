package com.springboot_first_app.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Deepti", "Wani", 20, 15092003);
    }

    // CREATE RESTAPI RETURNS LIST AS JSON ARRAY
    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Deepti", "Wani", 20, 15092003));
        students.add(new Student(2, "Trupti", "Jadhav", 21, 24082000));
        students.add(new Student(3, "Karina", "Sharma", 24, 19091997));
        students.add(new Student(4, "Ram", "Sharma", 23, 14072000));
        students.add(new Student(5, "Jiya", "Verma", 26, 12091996));
        return students;
    }

    // SPRINGBOOT REST API WITH PATH VARIABLE - @PathVariable
    // http://localhost:8080/student/1/Deepti/Wani/20/15092003
    @GetMapping("/student/{id}/{firstname}/{lastname}/{age}/{dob}")
    public Student studentPathVariable(@PathVariable("id") int id,
                                       @PathVariable("firstname") String firstname,
                                       @PathVariable("lastname") String lastname,
                                       @PathVariable("age") int age,
                                       @PathVariable("dob") int dob) {
        return new Student(id, firstname, lastname, age, dob);
    }

    // BUILD REST API TO HANDLE QUERY PARAMETERS
    // http://localhost:8080/student?firstname=Deepti&lastname=Wani&id=1&age=20&dob=15092003
    @GetMapping("/student/query")
    public Student studentQueryParam(
            @RequestParam(name="id") int id,
            @RequestParam(name="firstname") String firstname,
            @RequestParam(name="lastname") String lastname,
            @RequestParam(name="age") int age,
            @RequestParam(name="dob") int dob) {
        return new Student(id, firstname, lastname, age, dob);
    }
}
