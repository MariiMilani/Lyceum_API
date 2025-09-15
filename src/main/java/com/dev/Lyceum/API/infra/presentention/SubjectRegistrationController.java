package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.usecases.enrollment.ShowEnrollmentByIdUsecase;
import com.dev.Lyceum.API.core.usecases.subject.ShowSubjectByIdUsecase;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.CreateRegistrationUsecase;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.ShowAllRegistrationsUsecase;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.ShowRegistrationsByEnrollmentUsecase;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.ShowRegistrationsBySubjectUsecase;
import com.dev.Lyceum.API.infra.mapper.SubjectRegistrationMapper;
import com.dev.Lyceum.API.infra.presentention.dto.SubjectRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class SubjectRegistrationController {

    @Autowired
    public SubjectRegistrationMapper subjectRegistrationMapper;

    @Autowired
    private CreateRegistrationUsecase createRegistrationUsecase;

    @Autowired
    private ShowAllRegistrationsUsecase showAllRegistrationsUsecase;

    @Autowired
    private ShowSubjectByIdUsecase showSubjectByIdUsecase;

    @Autowired
    private ShowRegistrationsBySubjectUsecase showRegistrationsBySubjectUsecase;

    @Autowired
    private ShowEnrollmentByIdUsecase showEnrollmentByIdUsecase;

    @Autowired
    private ShowRegistrationsByEnrollmentUsecase showRegistrationsByEnrollmentUsecase;

    @PostMapping("/create")
    public ResponseEntity<SubjectRegistrationDto> createRegistration(@RequestBody SubjectRegistrationDto request) {
        Subject subject;
        Enrollment enrollment;

        if (request.subject() == null) {
            subject = showSubjectByIdUsecase.execute(null);
        } else {
            subject = showSubjectByIdUsecase.execute(request.subject().id());
        }

        if (request.enrollment() == null) {
            enrollment = showEnrollmentByIdUsecase.execute(null);
        } else {
            enrollment = showEnrollmentByIdUsecase.execute(request.enrollment());
        }


        SubjectRegistration newRegistration = createRegistrationUsecase.execute(subjectRegistrationMapper.dtoToDomain(request), enrollment, subject);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subjectRegistrationMapper.toDto(newRegistration));
    }

    @GetMapping
    public ResponseEntity<List<SubjectRegistrationDto>> showAllRegistrations() {
        List<SubjectRegistration> allRegistrations = showAllRegistrationsUsecase.execute();
        return ResponseEntity.ok(allRegistrations
                .stream()
                .map(subjectRegistrationMapper::toDto)
                .toList());
    }

    @GetMapping("/search/subject/{id}")
    public ResponseEntity<List<SubjectRegistrationDto>> showRegistrationsBySubject(@PathVariable Long id) {
        Subject subjectById = showSubjectByIdUsecase.execute(id);
        List<SubjectRegistration> registrations = showRegistrationsBySubjectUsecase.execute(subjectById);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(registrations.stream().map(subjectRegistrationMapper::toDto).toList());
    }

    @GetMapping("/search/enrollment/{id}")
    public ResponseEntity<List<SubjectRegistrationDto>> showRegistrationsByEnrollment(@PathVariable String id) {
        Enrollment enrollmentById = showEnrollmentByIdUsecase.execute(id);
        List<SubjectRegistration> registrations = showRegistrationsByEnrollmentUsecase.execute(enrollmentById);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(registrations.stream().map(subjectRegistrationMapper::toDto).toList());
    }
}
