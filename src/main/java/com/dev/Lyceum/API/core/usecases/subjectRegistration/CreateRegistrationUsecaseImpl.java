package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;

public class CreateRegistrationUsecaseImpl implements  CreateRegistrationUsecase{

    private final SubjectRegistrationGateway gateway;

    public CreateRegistrationUsecaseImpl(SubjectRegistrationGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public SubjectRegistration execute(SubjectRegistration registration) {
        return gateway.createRegistration(registration);
    }
}
