package com.dev.Lyceum.API.core.usecases.user;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.gateway.UserGateway;

public class CreateUserUsecaseImpl implements CreateUserUsecase {

    private final UserGateway userGateway;

    public CreateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return userGateway.createUser(user);
    }
}
