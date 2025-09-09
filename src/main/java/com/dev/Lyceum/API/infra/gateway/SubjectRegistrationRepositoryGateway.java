package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;
import com.dev.Lyceum.API.infra.mapper.SubjectRegistrationMapper;
import com.dev.Lyceum.API.infra.persistence.SubjectRegistrationEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.SubjectRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectRegistrationRepositoryGateway implements SubjectRegistrationGateway {

    @Autowired
    private SubjectRegistrationMapper subjectRegistrationMapper;

    @Autowired
    private SubjectRegistrationRepository repository;

    @Override
    public SubjectRegistration createRegistration(SubjectRegistration registration) {
        SubjectRegistrationEntity newRegistration = subjectRegistrationMapper.toEntity(registration);

        repository.insertSubjectRegistration(
                newRegistration.getSubject().getId(),
                newRegistration.getEnrollment().getId(),
                newRegistration.getGrade(),
                newRegistration.getStatusSubject().name()
        );
        /*repository.save(newRegistration);*/
        return subjectRegistrationMapper.entityToDomain(newRegistration);
    }
}
