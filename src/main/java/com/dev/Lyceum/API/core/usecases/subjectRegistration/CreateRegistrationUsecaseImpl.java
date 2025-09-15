package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;

public class CreateRegistrationUsecaseImpl implements CreateRegistrationUsecase {

    private final SubjectRegistrationGateway gateway;

    public CreateRegistrationUsecaseImpl(SubjectRegistrationGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public SubjectRegistration execute(SubjectRegistration registration, Enrollment enrollment, Subject subject) {
        return gateway.createRegistration(registration, enrollment, subject);
    }
}
