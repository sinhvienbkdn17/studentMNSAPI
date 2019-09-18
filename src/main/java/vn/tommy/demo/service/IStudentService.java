package vn.tommy.demo.service;

import vn.tommy.demo.model.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAll();
    Optional<Student> getById(Long id);
    boolean create(Student student);
    boolean edit(Student student);
    boolean delete(Long id);
}
