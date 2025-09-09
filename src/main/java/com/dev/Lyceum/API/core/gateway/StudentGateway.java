package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;

public interface StudentGateway {

    Student registerStudent(Student student);

    void assignEnrollment(Student student, Enrollment enrollment);
}
