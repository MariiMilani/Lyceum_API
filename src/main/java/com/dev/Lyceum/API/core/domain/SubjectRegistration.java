package com.dev.Lyceum.API.core.domain;

public record SubjectRegistration( Subject subject,
                                   Enrollment enrollment,
                                   String grade,
                                   StatusSubject statusSubject) {
}
