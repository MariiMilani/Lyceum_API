package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;

import java.util.List;

public class ShowRegistrationsByEnrollmentUsecaseImpl implements ShowRegistrationsByEnrollmentUsecase {

    private final SubjectRegistrationGateway subjectRegistrationGateway;

    public ShowRegistrationsByEnrollmentUsecaseImpl(SubjectRegistrationGateway subjectRegistrationGateway) {
        this.subjectRegistrationGateway = subjectRegistrationGateway;
    }

    @Override
    public List<SubjectRegistration> execute(Enrollment enrollmentId) {
        return subjectRegistrationGateway.registrationsByEnrollment(enrollmentId);
    }
}
