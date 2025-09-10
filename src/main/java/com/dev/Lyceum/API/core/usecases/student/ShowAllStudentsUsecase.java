package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;

import java.util.List;

public interface ShowAllStudentsUsecase {

    List<Student> execute();
}
