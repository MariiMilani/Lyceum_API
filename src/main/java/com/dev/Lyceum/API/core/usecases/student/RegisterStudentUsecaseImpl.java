package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.gateway.StudentGateway;

public class RegisterStudentUsecaseImpl implements RegisterStudentUsecase {

    private final StudentGateway studentGateway;

    public RegisterStudentUsecaseImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public Student execute(Student student) {
        return studentGateway.registerStudent(student);
    }
}
