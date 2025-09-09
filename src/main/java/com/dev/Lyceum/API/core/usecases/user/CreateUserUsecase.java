package com.dev.Lyceum.API.core.usecases.user;

import com.dev.Lyceum.API.core.domain.users.User;

public interface CreateUserUsecase {

    public User execute(User user);
}
