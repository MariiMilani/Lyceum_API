package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.gateway.StudentGateway;

public class RegisterStudentUsecaseImpl implements RegisterStudentUsecase {

    private final StudentGateway studentGateway;

    public RegisterStudentUsecaseImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public Student execute(Student student, User user) {
        return studentGateway.registerStudent(student, user);
    }
}
