package com.dev.Lyceum.API.core.usecases.subjectRegistration;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;

import java.util.List;

public interface ShowRegistrationsBySubjectUsecase {
    List<SubjectRegistration> execute(Subject subject);
}
