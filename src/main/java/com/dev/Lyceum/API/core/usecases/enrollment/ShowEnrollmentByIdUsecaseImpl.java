package com.dev.Lyceum.API.core.usecases.enrollment;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;

public class ShowEnrollmentByIdUsecaseImpl implements ShowEnrollmentByIdUsecase {

    private final EnrollmentGateway enrollmentGateway;

    public ShowEnrollmentByIdUsecaseImpl(EnrollmentGateway enrollmentGateway) {
        this.enrollmentGateway = enrollmentGateway;
    }

    @Override
    public Enrollment execute(String id) {
        return enrollmentGateway.showEnrollmentById(id);
    }
}
