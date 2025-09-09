package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;

public interface EnrollmentGateway {

    Enrollment createEnrollment(Enrollment enrollment);
}
