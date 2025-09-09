package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.usecases.enrollment.CreateEnrollmentUsecase;
import com.dev.Lyceum.API.core.usecases.student.AssignEnrollmentToStudentUsecase;
import com.dev.Lyceum.API.infra.mapper.EnrollmentMapper;
import com.dev.Lyceum.API.infra.mapper.StudentMapper;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.StudentRepository;
import com.dev.Lyceum.API.infra.presentention.dto.EnrollmentDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private CreateEnrollmentUsecase createEnrollmentUsecase;
    @Autowired
    private EnrollmentMapper enrollmentMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AssignEnrollmentToStudentUsecase assignEnrollmentToStudentUsecase;
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/create")
    public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody EnrollmentDto request) {

        StudentEntity student = studentRepository.findByIdWithUser(request.student().id())
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + request.student().id()));


        Enrollment newEnrollment = createEnrollmentUsecase.execute(enrollmentMapper.dtoToDomain(request));

        assignEnrollmentToStudentUsecase.execute(studentMapper.entityToDomain(student), newEnrollment);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(enrollmentMapper.toDto(newEnrollment));
    }
}
