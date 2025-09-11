package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;

public interface ShowStudentByIdUsecase {

    Student execute(Long id);
}
