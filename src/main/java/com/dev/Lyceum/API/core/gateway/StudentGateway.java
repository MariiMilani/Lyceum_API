package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;

import java.util.List;

public interface StudentGateway {

    Student registerStudent(Student student);

    void assignEnrollment(Student student, Enrollment enrollment);

    List<Student> showAllStudents();
}
