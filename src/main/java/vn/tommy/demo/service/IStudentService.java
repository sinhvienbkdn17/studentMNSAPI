package vn.tommy.demo.service;

import vn.tommy.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student GetById(Long id);
    boolean create(Student student);
    boolean edit(Student student);
    boolean delete(Long id);
}
