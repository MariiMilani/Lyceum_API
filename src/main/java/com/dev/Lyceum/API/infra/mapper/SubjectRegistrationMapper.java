package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.infra.persistence.EnrollmentEntity;
import com.dev.Lyceum.API.infra.persistence.SubjectRegistrationEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.EnrollmentRepository;
import com.dev.Lyceum.API.infra.presentention.dto.SubjectRegistrationDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubjectRegistrationMapper {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public SubjectRegistration dtoToDomain(SubjectRegistrationDto subjectRegistrationDto) {
        return new SubjectRegistration(subjectRegistrationDto.id(), subjectMapper.dtoToDomain(subjectRegistrationDto.subject()), subjectRegistrationDto.enrollment(), subjectRegistrationDto.grade(), subjectRegistrationDto.statusSubject());
    }

    public SubjectRegistration entityToDomain(SubjectRegistrationEntity entity) {
        return new SubjectRegistration(entity.getId(), subjectMapper.entityToDomain(entity.getSubject()), entity.getEnrollment().getId(), entity.getGrade(), entity.getStatusSubject());
    }

    public SubjectRegistrationDto toDto(SubjectRegistration subjectRegistration) {
        EnrollmentEntity enrollment = getEnrollment(subjectRegistration.enrollment())
                .orElseThrow(() -> new EntityNotFoundException("Enrollment " + subjectRegistration.enrollment() + " not found"));
        return new SubjectRegistrationDto(subjectRegistration.id(), subjectMapper.toDto(subjectRegistration.subject()), enrollment.getId(), subjectRegistration.grade(), subjectRegistration.statusSubject());
    }

    public SubjectRegistrationEntity toEntity(SubjectRegistration subjectRegistration) {
        EnrollmentEntity enrollment = getEnrollment(subjectRegistration.enrollment())
                .orElseThrow(() -> new EntityNotFoundException("Enrollment " + subjectRegistration.enrollment() + " not found"));
        return new SubjectRegistrationEntity(subjectRegistration.id(), subjectMapper.toEntity(subjectRegistration.subject()), enrollment, subjectRegistration.grade(), subjectRegistration.statusSubject());
    }

    private Optional<EnrollmentEntity> getEnrollment(String id) {
        return enrollmentRepository.findById(id);
    }

}
