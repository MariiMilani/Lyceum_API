package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.usecases.student.RegisterStudentUsecase;
import com.dev.Lyceum.API.core.usecases.student.ShowAllStudentsUsecase;
import com.dev.Lyceum.API.core.usecases.student.ShowStudentByIdUsecase;
import com.dev.Lyceum.API.core.usecases.user.ShowUserByIdUsecase;
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

    @Autowired
    private ShowStudentByIdUsecase showStudentByIdUsecase;

    @Autowired
    private ShowUserByIdUsecase showUserByIdUsecase;

    @PostMapping("/register")
    public ResponseEntity<StudentDto> registerStudent(@RequestBody StudentDto request) {
        User userById;
        if (request.user() == null) {
            userById = showUserByIdUsecase.execute(null);
        } else {
            userById = showUserByIdUsecase.execute(request.user().id());
        }

        Student newStudent = registerStudentUsecase.execute(studentMapper.dtoToDomain(request), userById);
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

    @GetMapping("/search/{id}")
    public ResponseEntity<StudentDto> showStudentById(@PathVariable Long id) {
        Student studentById = showStudentByIdUsecase.execute(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(studentMapper.toDto(studentById));
    }
}
