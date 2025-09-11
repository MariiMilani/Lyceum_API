package com.dev.Lyceum.API.core.usecases.subject;

import com.dev.Lyceum.API.core.domain.Subject;

public interface ShowSubjectByIdUsecase {

    Subject execute(Long id);
}
