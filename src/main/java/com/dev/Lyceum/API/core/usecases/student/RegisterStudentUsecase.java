package com.dev.Lyceum.API.core.usecases.student;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.domain.users.User;

public interface RegisterStudentUsecase {

    Student execute(Student student, User user);
}
