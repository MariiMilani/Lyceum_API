package com.dev.Lyceum.API.infra.presentention.dto;

import java.util.List;

public record EnrollmentDto(String id,
                            StudentDto student,
                            List<SubjectRegistrationDto> subjects) {
}
