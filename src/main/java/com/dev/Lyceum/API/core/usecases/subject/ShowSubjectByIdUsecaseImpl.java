package com.dev.Lyceum.API.core.usecases.subject;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.gateway.SubjectGateway;

public class ShowSubjectByIdUsecaseImpl implements ShowSubjectByIdUsecase {

    private final SubjectGateway subjectGateway;

    public ShowSubjectByIdUsecaseImpl(SubjectGateway subjectGateway) {
        this.subjectGateway = subjectGateway;
    }

    @Override
    public Subject execute(Long id) {
        return subjectGateway.showSubjectById(id);
    }
}
