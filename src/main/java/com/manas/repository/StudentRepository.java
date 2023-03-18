package com.manas.repository;

import com.manas.dto.response.StudentResponse;
import com.manas.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new com.manas.dto.response.StudentResponse(s.id,s.name,s.age,s.email,s.isBlocked) from Student s")
    List<StudentResponse> getAllStudents();

    Optional<StudentResponse> getStudentById(Long studentId);//we don't need query because it already has

    List<StudentResponse> getStudentsByIsBlocked(Boolean isBlocked);
}