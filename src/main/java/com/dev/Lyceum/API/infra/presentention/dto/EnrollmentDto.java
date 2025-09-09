package com.dev.Lyceum.API.infra.presentention.dto;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.domain.users.Student;

import java.util.List;

public record EnrollmentDto(String id,
                            Student student,
                            List<SubjectRegistration> subjects) {
}
