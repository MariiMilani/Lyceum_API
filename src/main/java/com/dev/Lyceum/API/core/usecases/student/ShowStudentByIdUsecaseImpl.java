package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.gateway.StudentGateway;

public class ShowStudentByIdUsecaseImpl implements ShowStudentByIdUsecase {

    private final StudentGateway studentGateway;

    public ShowStudentByIdUsecaseImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public Student execute(Long id) {
        return studentGateway.showStudentById(id);
    }
}
