package vn.tommy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tommy.demo.model.Student;
import vn.tommy.demo.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        List<Student> listStudents = studentRepository.findAll();
        if(listStudents.size() > 0) {
            return listStudents;
        }

        return Collections.emptyList();
    }

    @Override
    public Student GetById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            return student.get();
        }
        throw new EntityNotFoundException("No Student found");
    }

    @Override
    public boolean create(Student student) {
        boolean isCreated = true;
        try {
            if(student.checkValidEntity()){
                studentRepository.save(student);
            }
        }
        catch (Exception ex){
            isCreated = false;
        }

        return isCreated;
    }

    @Override
    public boolean edit(Student newStudent) {
        boolean isEditd = true;
        Optional<Student> oldStudent = studentRepository.findById(newStudent.getId());
        Student student = null;
        if(oldStudent.isPresent()) {
            student  = oldStudent.get();
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            student.setEmail(newStudent.getEmail());
            student.setBirthDay(newStudent.getBirthDay());
        }

        try {
            if(student.checkValidEntity()) {
                studentRepository.save(student);
            }
        }
        catch (Exception ex) {
            isEditd = false;
        }

        return isEditd;
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = true;
        Optional<Student> student = studentRepository.findById(id);
        try {
            if(student.isPresent()) {
                studentRepository.delete(student.get());
            }
        }
        catch (Exception ex) {
            isDeleted = false;
        }

        return isDeleted;
    }
}
