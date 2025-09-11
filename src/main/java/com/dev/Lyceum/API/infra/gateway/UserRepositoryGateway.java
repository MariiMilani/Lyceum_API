package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.gateway.UserGateway;
import com.dev.Lyceum.API.infra.exception.EntityNotFoundException;
import com.dev.Lyceum.API.infra.mapper.UserMapper;
import com.dev.Lyceum.API.infra.persistence.UserEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryGateway implements UserGateway {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper mapper;

    @Override
    public User createUser(User user) {
        UserEntity savedUser = repository.save(mapper.toEntity(user));
        return mapper.entityToDomain(savedUser);
    }

    @Override
    public List<User> showAllUsers() {
        return repository.findAll().stream()
                .map(mapper::entityToDomain)
                .toList();
    }

    @Override
    public User showUserById(Long id) {
        UserEntity userById = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.entityToDomain(userById);
    }
}
