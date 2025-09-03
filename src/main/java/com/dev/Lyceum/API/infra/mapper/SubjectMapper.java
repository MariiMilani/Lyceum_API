package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.infra.persistence.SubjectEntity;
import com.dev.Lyceum.API.infra.presentention.dto.SubjectDto;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public Subject dtoToDomain(SubjectDto request) {
        return new Subject(request.id(), request.name());
    }

    public Subject entityToDomain(SubjectEntity entity) {
        return new Subject(entity.getId(), entity.getName());
    }

    public SubjectDto toDto(Subject subject) {
        return new SubjectDto(subject.id(), subject.name());
    }

    public SubjectEntity toEntity(Subject subject) {
        return new SubjectEntity(subject.id(), subject.name());
    }
}
