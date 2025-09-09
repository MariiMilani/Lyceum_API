package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;

public interface CreateRegistrationUsecase {

    SubjectRegistration execute(SubjectRegistration registration);
}
