package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.domain.users.User;

import java.util.List;

public interface StudentGateway {

    Student registerStudent(Student student, User user);

    void assignEnrollment(Student student, Enrollment enrollment);

    List<Student> showAllStudents();

    Student showStudentById(Long id);
}
