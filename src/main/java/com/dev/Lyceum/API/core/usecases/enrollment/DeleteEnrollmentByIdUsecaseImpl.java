package com.dev.Lyceum.API.core.usecases.enrollment;

import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;

public class DeleteEnrollmentByIdUsecaseImpl implements DeleteEnrollmentByIdUsecase {

    private final EnrollmentGateway enrollmentGateway;

    public DeleteEnrollmentByIdUsecaseImpl(EnrollmentGateway enrollmentGateway) {
        this.enrollmentGateway = enrollmentGateway;
    }

    @Override
    public String execute(String id) {
        return enrollmentGateway.deleteEnrollmentById(id);
    }
}
