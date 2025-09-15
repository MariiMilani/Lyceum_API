package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.StatusSubject;
import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;
import com.dev.Lyceum.API.infra.exception.NotNullFieldException;
import com.dev.Lyceum.API.infra.mapper.EnrollmentMapper;
import com.dev.Lyceum.API.infra.mapper.SubjectMapper;
import com.dev.Lyceum.API.infra.mapper.SubjectRegistrationMapper;
import com.dev.Lyceum.API.infra.persistence.SubjectRegistrationEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.SubjectRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectRegistrationRepositoryGateway implements SubjectRegistrationGateway {

    @Autowired
    private SubjectRegistrationMapper subjectRegistrationMapper;

    @Autowired
    private SubjectRegistrationRepository repository;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public SubjectRegistration createRegistration(SubjectRegistration registration, Enrollment enrollment, Subject subject) {

        if (registration.subject() == null || registration.enrollment() == null) {
            throw new NotNullFieldException("Enrollment and Subject can't be null");
        }

        if (registration.statusSubject() == StatusSubject.COMPLETED && registration.grade() == null) {
            throw new NotNullFieldException("If status is completed, grade can't be null");
        }

        if (registration.statusSubject() != StatusSubject.COMPLETED && registration.grade() != null) {
            throw new NotNullFieldException("Grade is only for completed status");
        }

        SubjectRegistrationEntity newRegistration = subjectRegistrationMapper.toEntity(registration);

        repository.insertSubjectRegistration(
                subject.id(),
                enrollment.id(),
                newRegistration.getGrade(),
                newRegistration.getStatusSubject().name()
        );

        newRegistration.setSubject(subjectMapper.toEntity(subject));

        return subjectRegistrationMapper.entityToDomain(newRegistration);
    }

    @Override
    public List<SubjectRegistration> allRegistrations() {
        return repository.findAll()
                .stream()
                .map(subjectRegistrationMapper::entityToDomain)
                .toList();
    }

    @Override
    public List<SubjectRegistration> registrationsBySubject(Subject subject) {
        List<SubjectRegistrationEntity> registrations = repository.findAllRegistrationBySubject(subject.id())
                .orElse(null);

        if (registrations != null) {
            return registrations
                    .stream()
                    .map(subjectRegistrationMapper::entityToDomain)
                    .toList();
        }
        return null;
    }

    @Override
    public List<SubjectRegistration> registrationsByEnrollment(Enrollment enrollment) {
        List<SubjectRegistrationEntity> registrations = repository.findAllRegistrationByEnrollment(enrollment.id())
                .orElse(null);
        if (registrations != null) {
            return registrations.stream()
                    .map(subjectRegistrationMapper::entityToDomain)
                    .toList();
        }
        return null;
    }
}
