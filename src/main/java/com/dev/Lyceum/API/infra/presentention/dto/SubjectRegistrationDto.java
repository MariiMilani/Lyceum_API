package com.dev.Lyceum.API.infra.presentention.dto;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.StatusSubject;
import com.dev.Lyceum.API.core.domain.Subject;

public record SubjectRegistrationDto(Long id,
                                     Subject subject,
                                     Enrollment enrollment,
                                     String grade,
                                     StatusSubject statusSubject) {
}
