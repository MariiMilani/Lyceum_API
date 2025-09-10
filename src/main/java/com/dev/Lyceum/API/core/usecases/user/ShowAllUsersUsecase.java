package com.dev.Lyceum.API.core.usecases.user;

import com.dev.Lyceum.API.core.domain.users.User;

import java.util.List;

public interface ShowAllUsersUsecase {

    List<User> execute();
}
