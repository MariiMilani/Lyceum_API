package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;

import java.util.List;

public interface EnrollmentGateway {

    Enrollment createEnrollment(Enrollment enrollment);

    List<Enrollment> showAllEnrollments();

    String deleteEnrollmentById(Enrollment enrollment);

    Enrollment showEnrollmentById(String id);
}
