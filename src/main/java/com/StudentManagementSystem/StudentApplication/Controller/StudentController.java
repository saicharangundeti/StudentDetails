package com.StudentManagementSystem.StudentApplication.Controller;

import com.StudentManagementSystem.StudentApplication.Entity.Student;
import com.StudentManagementSystem.StudentApplication.Service.StudentService;
import com.StudentManagementSystem.StudentApplication.StudentApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")

public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAll());
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        if(studentService.getStudent(id) != null) {
            return ResponseEntity.ok(studentService.getStudent(id));
        };
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PostMapping("/students")
    public ResponseEntity<Student> postStudent(@RequestBody Student student){
        if(studentService.getStudent(student.getId()) == null){
            studentService.addStudent(student);
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        if(studentService.getStudent(student.getId()) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        studentService.updateStudent(student);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable int id){
        if(studentService.getStudent(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
        studentService.deleteStudent(id);
        return ResponseEntity.ok(true);
    }


}
