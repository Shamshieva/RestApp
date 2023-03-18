package com.manas.service.impl;

import com.manas.dto.request.StudentRequest;
import com.manas.dto.response.SimpleResponse;
import com.manas.dto.response.StudentResponse;
import com.manas.entity.Student;
import com.manas.repository.StudentRepository;
import com.manas.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        student.setLocalDate(LocalDate.now());
        student.setIsBlocked(false);
        studentRepository.save(student);
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail(),
                student.getIsBlocked());
    }

    @Override
    public StudentResponse getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with id:" + studentId+"not found"));
    }

    @Override
    public List<StudentResponse> getAllStudents() {
       return studentRepository.getAllStudents();
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with id:" + studentId+"not found"));

        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail(),
                student.getIsBlocked());
    }

    @Override
    public String deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
       if (!exists){
           throw new NoSuchElementException("Student with id:" + studentId+"not found");
       }
       studentRepository.deleteById(studentId);
        return String.format("Student with id:%d is deleted", studentId);
    }

    @Override
    public List<StudentResponse> getStudentsByIsBlockedOrNot(Boolean isBlocked) {
        return studentRepository.getStudentsByIsBlocked(isBlocked);
    }

    @Override
    public SimpleResponse blockUnblockStudent(Long studentId, Boolean block) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with id:" + studentId+"not found"));
        student.setIsBlocked(block);
        studentRepository.save(student);
        return new SimpleResponse("Blocked", "Student with id"+studentId+"is blocked");
    }
}
