package com.dev.Lyceum.API.core.usecases.user;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.gateway.UserGateway;

import java.util.List;

public class ShowAllUsersUsecaseImpl implements ShowAllUsersUsecase {

    private final UserGateway userGateway;

    public ShowAllUsersUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.showAllUsers();
    }
}
