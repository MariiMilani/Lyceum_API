package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;
import com.dev.Lyceum.API.infra.mapper.EnrollmentMapper;
import com.dev.Lyceum.API.infra.persistence.EnrollmentEntity;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.EnrollmentRepository;
import com.dev.Lyceum.API.infra.utils.EnrollmentIdGenerator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        if (student.getUser() == null){
            throw new IllegalStateException("Student must have a user");
        }

        EnrollmentEntity newEnrollment = enrollmentMapper.toEntity(enrollment, student);
        newEnrollment.setStudent(student);

        EnrollmentEntity teste = new EnrollmentEntity();
        teste.setId(newEnrollment.getId());

        enrollmentRepository.save(teste);
        return enrollmentMapper.entityToDomain(newEnrollment);
    }
}
