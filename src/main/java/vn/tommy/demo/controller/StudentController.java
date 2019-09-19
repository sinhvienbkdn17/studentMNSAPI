package vn.tommy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tommy.demo.model.Student;
import vn.tommy.demo.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:4200")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = studentService.getAll();
        if(studentList.size() > 0) {
            return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long Id) {
        Optional<Student> student = studentService.getById(Id);
        if(student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Student student) {
        if (student.checkValidEntity()) {
            if (studentService.create(student)) {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity edit(@RequestBody Student student) {
        if (student.checkValidEntity()) {
            if (studentService.edit(student)) {
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long Id) {
        Optional<Student> student = studentService.getById(Id);
        if(student.isPresent()){
            if(studentService.delete(Id)){
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
