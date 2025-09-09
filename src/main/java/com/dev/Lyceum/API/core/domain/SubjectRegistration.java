package com.dev.Lyceum.API.core.domain;

public record SubjectRegistration(Long id,
                                  Subject subject,
                                  String enrollment,
                                  String grade,
                                  StatusSubject statusSubject) {
}
