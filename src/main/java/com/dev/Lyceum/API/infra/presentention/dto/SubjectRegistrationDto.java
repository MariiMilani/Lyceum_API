package com.dev.Lyceum.API.infra.presentention.dto;

import com.dev.Lyceum.API.core.domain.StatusSubject;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record SubjectRegistrationDto(@JsonIgnore Long id,
                                     SubjectDto subject,
                                     String enrollment,
                                     String grade,
                                     StatusSubject statusSubject) {
}
