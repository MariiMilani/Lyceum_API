package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.gateway.SubjectGateway;
import com.dev.Lyceum.API.infra.mapper.SubjectMapper;
import com.dev.Lyceum.API.infra.persistence.SubjectEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectRepositoryGateway implements SubjectGateway {

    @Autowired
    private SubjectRepository repository;
    @Autowired
    private SubjectMapper mapper;

    @Override
    public Subject createSubject(Subject subject) {
        SubjectEntity newSubject = repository.save(mapper.toEntity(subject));
        return mapper.entityToDomain(newSubject);
    }

    @Override
    public List<Subject> showAllSubjects() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDomain)
                .toList();
    }
}
