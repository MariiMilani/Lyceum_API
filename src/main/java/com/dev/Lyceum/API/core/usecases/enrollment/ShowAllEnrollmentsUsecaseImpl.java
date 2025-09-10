package com.dev.Lyceum.API.core.usecases.enrollment;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;

import java.util.List;

public class ShowAllEnrollmentsUsecaseImpl implements ShowAllEnrollmentsUsecase {

    private final EnrollmentGateway enrollmentGateway;

    public ShowAllEnrollmentsUsecaseImpl(EnrollmentGateway enrollmentGateway) {
        this.enrollmentGateway = enrollmentGateway;
    }

    @Override
    public List<Enrollment> execute() {
        return enrollmentGateway.showAllEnrollments();
    }
}
