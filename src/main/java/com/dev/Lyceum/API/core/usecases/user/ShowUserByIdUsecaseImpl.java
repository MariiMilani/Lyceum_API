package com.dev.Lyceum.API.core.usecases.user;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.gateway.UserGateway;

public class ShowUserByIdUsecaseImpl implements ShowUserByIdUsecase {

    private final UserGateway userGateway;

    public ShowUserByIdUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id) {
        return userGateway.showUserById(id);
    }
}
