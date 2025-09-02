package com.dev.Lyceum.API.core.domain;

import com.dev.Lyceum.API.core.domain.users.Student;

import java.util.List;

public record Enrollment (String id,
                          Student student,
                          List<SubjectRegistration> subjects){
}
