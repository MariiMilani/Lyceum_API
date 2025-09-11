package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;
import com.dev.Lyceum.API.infra.mapper.EnrollmentMapper;
import com.dev.Lyceum.API.infra.persistence.EnrollmentEntity;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.EnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrollmentRepositoryGateway implements EnrollmentGateway {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {

        StudentEntity student = enrollmentRepository.findByStudentId(enrollment.student().id())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        if (student.getUser() == null) {
            throw new IllegalStateException("Student must have a user");
        }

        EnrollmentEntity newEnrollment = enrollmentMapper.toEntity(enrollment, student);
        newEnrollment.setStudent(student);

        enrollmentRepository.save(newEnrollment);
        return enrollmentMapper.entityToDomain(newEnrollment);
    }

    @Override
    public List<Enrollment> showAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::entityToDomain)
                .toList();
    }

    @Override
    public String deleteEnrollmentById(Enrollment enrollment) {
        if (enrollment.student() != null) {
            throw new RuntimeException("Enrollment has a student, please verify the given id");
        }

        enrollmentRepository.deleteById(enrollment.id());
        return enrollment.id();
    }

    @Override
    public Enrollment showEnrollmentById(String id) {
        EnrollmentEntity enrollmentById = enrollmentRepository.findById(id)
                .orElseThrow(() -> new com.dev.Lyceum.API.infra.exception.EntityNotFoundException("Enrollment not found"));
        return enrollmentMapper.entityToDomain(enrollmentById);
    }
}
