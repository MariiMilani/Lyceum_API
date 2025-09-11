package com.dev.Lyceum.API.core.usecases.user;

import com.dev.Lyceum.API.core.domain.users.User;

public interface ShowUserByIdUsecase {

    User execute(Long id);
}
