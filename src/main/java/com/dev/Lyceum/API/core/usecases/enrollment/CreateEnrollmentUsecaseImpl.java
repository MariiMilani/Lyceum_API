package com.dev.Lyceum.API.core.usecases.enrollment;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;

public class CreateEnrollmentUsecaseImpl implements CreateEnrollmentUsecase {

    private final EnrollmentGateway enrollmentGateway;

    public CreateEnrollmentUsecaseImpl(EnrollmentGateway enrollmentGateway) {
        this.enrollmentGateway = enrollmentGateway;
    }

    @Override
    public Enrollment execute(Enrollment enrollment) {
        return enrollmentGateway.createEnrollment(enrollment);
    }
}
