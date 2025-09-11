package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;

import java.util.List;

public interface ShowRegistrationsByEnrollmentUsecase {

    List<SubjectRegistration> execute(Enrollment enrollment);
}
