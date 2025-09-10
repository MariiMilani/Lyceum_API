package com.dev.Lyceum.API.core.usecases.enrollment;

import com.dev.Lyceum.API.core.domain.Enrollment;

import java.util.List;

public interface ShowAllEnrollmentsUsecase {

    List<Enrollment> execute();
}
