package com.manas.api;


import com.manas.dto.request.StudentRequest;
import com.manas.dto.response.SimpleResponse;
import com.manas.dto.response.StudentResponse;
import com.manas.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping
    public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }


    @GetMapping("/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public StudentResponse updateStudent(@PathVariable Long studentId,
                                         @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentId, studentRequest);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/block")
    public List<StudentResponse> getAllStudentsByBlockedOrNot(@RequestParam(required = false) Boolean isBlocked) {
        return studentService.getStudentsByIsBlockedOrNot(isBlocked);
    }

    @PostMapping("/{studentId}")
    public SimpleResponse blockUnblockStudent(@PathVariable Long studentId,
                                              @RequestParam Boolean block){
        return studentService.blockUnblockStudent(studentId, block);
    }
}
