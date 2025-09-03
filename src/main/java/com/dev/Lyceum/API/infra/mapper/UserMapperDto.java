package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.infra.presentention.dto.UserDto;

public class UserMapperDto {

    public User toDomain (UserDto request){
        return new User(request.id(), request.name(), request.email(), request.identifier(), request.createdAt());
    }

    public UserDto toDto (User user){
        return new UserDto(user.id(), user.name(), user.email(), user.identifier(), user.createdAt());
    }
}
