package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;

public interface AssignEnrollmentToStudentUsecase {

    void execute (Student student, Enrollment enrollment);
}
