package com.dev.Lyceum.API.core.usecases.subject;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.gateway.SubjectGateway;

public class CreateSubjectUsecaseImpl implements CreateSubjectUsecase {

    private final SubjectGateway subjectGateway;

    public CreateSubjectUsecaseImpl(SubjectGateway subjectGateway) {
        this.subjectGateway = subjectGateway;
    }

    @Override
    public Subject execute(Subject subject) {
        return subjectGateway.createSubject(subject);
    }
}
