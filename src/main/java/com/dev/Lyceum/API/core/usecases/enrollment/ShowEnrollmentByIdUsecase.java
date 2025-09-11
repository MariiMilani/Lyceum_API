package com.dev.Lyceum.API.core.usecases.enrollment;

import com.dev.Lyceum.API.core.domain.Enrollment;

public interface ShowEnrollmentByIdUsecase {

    Enrollment execute(String id);
}
