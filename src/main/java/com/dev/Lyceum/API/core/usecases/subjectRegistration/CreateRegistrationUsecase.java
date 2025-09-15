package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;

public interface CreateRegistrationUsecase {

    SubjectRegistration execute(SubjectRegistration registration, Enrollment enrollment, Subject subject);
}
