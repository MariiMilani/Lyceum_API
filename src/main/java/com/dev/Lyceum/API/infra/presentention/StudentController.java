package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.usecases.student.RegisterStudentUsecase;
import com.dev.Lyceum.API.infra.mapper.StudentMapper;
import com.dev.Lyceum.API.infra.presentention.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private RegisterStudentUsecase registerStudentUsecase;
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/register")
    public ResponseEntity<StudentDto> registerStudent(@RequestBody StudentDto request) {
        Student newStudent = registerStudentUsecase.execute(studentMapper.dtoToDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentMapper.toDto(newStudent));
    }
}
