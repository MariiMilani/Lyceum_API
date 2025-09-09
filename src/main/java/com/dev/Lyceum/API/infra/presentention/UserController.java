package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.usecases.user.CreateUserUsecase;
import com.dev.Lyceum.API.infra.mapper.UserMapper;
import com.dev.Lyceum.API.infra.presentention.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUsecase createUserUsecase;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) {
        User newUser = createUserUsecase.execute(userMapper.dtoToDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toDto(newUser));
    }
}
