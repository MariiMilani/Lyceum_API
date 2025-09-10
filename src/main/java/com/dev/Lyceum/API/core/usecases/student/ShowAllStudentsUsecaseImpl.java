package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.gateway.StudentGateway;

import java.util.List;

public class ShowAllStudentsUsecaseImpl implements ShowAllStudentsUsecase {

    private final StudentGateway studentGateway;

    public ShowAllStudentsUsecaseImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public List<Student> execute() {
        return studentGateway.showAllStudents();
    }
}
