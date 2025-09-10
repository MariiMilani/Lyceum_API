package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.users.User;

import java.util.List;

public interface UserGateway {

    User createUser(User user);

    List<User> showAllUsers();
}
