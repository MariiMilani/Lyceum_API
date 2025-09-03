package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.infra.persistence.UserEntity;
import com.dev.Lyceum.API.infra.presentention.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User dtoToDomain (UserDto request){
        return new User(request.id(), request.name(), request.email(), request.identifier(), request.createdAt());
    }

    public User entityToDomain (UserEntity entity){
        return new User(entity.getId(), entity.getName(), entity.getEmail(), entity.getIdentifier(), entity.getCreatedAt());
    }

    public UserDto toDto (User user){
        return new UserDto(user.id(), user.name(), user.email(), user.identifier(), user.createdAt());
    }

    public UserEntity toEntity (User user){
        return new UserEntity(user.id(), user.name(), user.email(), user.identifier(), user.createdAt());
    }
}
