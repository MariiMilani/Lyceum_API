package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.gateway.StudentGateway;

public class AssignEnrollmentToStudentUsecaseImpl implements AssignEnrollmentToStudentUsecase {

    private final StudentGateway studentGateway;

    public AssignEnrollmentToStudentUsecaseImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public void execute(Student student, Enrollment enrollment) {
        studentGateway.assignEnrollment(student, enrollment);
    }
}
