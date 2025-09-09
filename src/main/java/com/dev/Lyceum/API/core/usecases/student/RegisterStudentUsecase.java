package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;

public interface RegisterStudentUsecase {

    Student execute(Student student);
}
