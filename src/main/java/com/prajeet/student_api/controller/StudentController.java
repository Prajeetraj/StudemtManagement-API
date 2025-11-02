//package com.prajeet.student_api.controller;
//
//
//import com.prajeet.student_api.model.Student;
//import com.prajeet.student_api.model.repositary.StudentRepositor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    @Autowired
//    private StudentRepositor studentRepository;
//
//    // GET all students
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    // GET a student by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
//        Optional<Student> student = studentRepository.findById(id);
//        return student.map(ResponseEntity::ok)
//                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//    }
//
//    // POST add a new student
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//    }
// Prajeet
//
//    // PUT update a student by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
//        Optional<Student> optionalStudent = studentRepository.findById(id);
//        if (optionalStudent.isPresent()) {
//            Student student = optionalStudent.get();
//            student.setName(studentDetails.getName());
//            student.setAge(studentDetails.getAge());
//            student.setGender(studentDetails.getGender());
//            student.setRollNumber(studentDetails.getRollNumber());
//            student.setPhoneNumber(studentDetails.getPhoneNumber());
//            student.setAddress(studentDetails.getAddress());
//            studentRepository.save(student);
//            return ResponseEntity.ok(student);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    // DELETE a student by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
//        if (studentRepository.existsById(id)) {
//            studentRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//}


package com.prajeet.student_api.controller;

import com.prajeet.student_api.model.Student;
import com.prajeet.student_api.model.repositary.StudentRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")           // Allows React (port 3000) to access backend (port 9090)
@RestController                                           // Makes class REST API
@RequestMapping("/students")                              // Base path for API
public class StudentController {                          // Exposes REST API endpoints for the frontend.

    @Autowired
    private StudentRepositor studentRepository;

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // POST add a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // PUT update a student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            student.setGender(studentDetails.getGender());
            student.setRollNumber(studentDetails.getRollNumber());
            student.setPhoneNumber(studentDetails.getPhoneNumber());
            student.setAddress(studentDetails.getAddress());
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // DELETE a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}


