package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.usecases.student.RegisterStudentUsecase;
import com.dev.Lyceum.API.core.usecases.student.ShowAllStudentsUsecase;
import com.dev.Lyceum.API.infra.mapper.StudentMapper;
import com.dev.Lyceum.API.infra.presentention.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RegisterStudentUsecase registerStudentUsecase;

    @Autowired
    private ShowAllStudentsUsecase showAllStudentsUsecase;

    @PostMapping("/register")
    public ResponseEntity<StudentDto> registerStudent(@RequestBody StudentDto request) {
        Student newStudent = registerStudentUsecase.execute(studentMapper.dtoToDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentMapper.toDto(newStudent));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> showAllStudents() {
        List<Student> allStudents = showAllStudentsUsecase.execute();
        return ResponseEntity.ok(allStudents.stream()
                .map(studentMapper::toDto)
                .toList());
    }
}
