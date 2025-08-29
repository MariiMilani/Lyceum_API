package com.dev.Lyceum.API.core.domain;

import com.dev.Lyceum.API.core.domain.users.Student;

import java.util.List;

public class Enrollment {

    public Long id;

    public Student student;

    public List<SubjectRegistration> subjects;
}
