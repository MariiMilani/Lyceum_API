package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;

import java.util.List;

public class ShowAllRegistrationsUsecaseImpl implements ShowAllRegistrationsUsecase {

    private final SubjectRegistrationGateway subjectRegistrationGateway;

    public ShowAllRegistrationsUsecaseImpl(SubjectRegistrationGateway subjectRegistrationGateway) {
        this.subjectRegistrationGateway = subjectRegistrationGateway;
    }

    @Override
    public List<SubjectRegistration> execute() {
        return subjectRegistrationGateway.allRegistrations();
    }
}
