package com.manas.service;

import com.manas.dto.request.StudentRequest;
import com.manas.dto.response.SimpleResponse;
import com.manas.dto.response.StudentResponse;
import com.manas.entity.Student;

import java.util.List;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse getStudentById(Long studentId);

    List<StudentResponse> getAllStudents();

    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);

    String deleteStudent(Long studentId);

    List<StudentResponse> getStudentsByIsBlockedOrNot(Boolean isBlocked);

    SimpleResponse blockUnblockStudent(Long studentId, Boolean block);
}
