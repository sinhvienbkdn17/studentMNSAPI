package vn.tommy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.tommy.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
