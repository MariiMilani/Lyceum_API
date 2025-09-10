package com.dev.Lyceum.API.infra.presentention.dto;

import com.dev.Lyceum.API.core.domain.StatusSubject;

public record SubjectRegistrationDto(Long id,
                                     SubjectDto subject,
                                     String enrollment,
                                     String grade,
                                     StatusSubject statusSubject) {
}
