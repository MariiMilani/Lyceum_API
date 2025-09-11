package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;

import java.util.List;

public class ShowRegistrationsBySubjectUsecaseImpl implements ShowRegistrationsBySubjectUsecase {

    private final SubjectRegistrationGateway subjectRegistrationGateway;

    public ShowRegistrationsBySubjectUsecaseImpl(SubjectRegistrationGateway subjectRegistrationGateway) {
        this.subjectRegistrationGateway = subjectRegistrationGateway;
    }

    @Override
    public List<SubjectRegistration> execute(Subject subject) {
        return subjectRegistrationGateway.registrationsBySubject(subject);
    }
}
