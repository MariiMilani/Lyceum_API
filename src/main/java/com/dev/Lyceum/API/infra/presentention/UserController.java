package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.users.User;
import com.dev.Lyceum.API.core.usecases.user.CreateUserUsecase;
import com.dev.Lyceum.API.core.usecases.user.ShowAllUsersUsecase;
import com.dev.Lyceum.API.infra.mapper.UserMapper;
import com.dev.Lyceum.API.infra.presentention.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CreateUserUsecase createUserUsecase;

    @Autowired
    private ShowAllUsersUsecase showAllUsersUsecase;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) {
        User newUser = createUserUsecase.execute(userMapper.dtoToDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toDto(newUser));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> showAllUsers() {
        List<User> allUsers = showAllUsersUsecase.execute();
        return ResponseEntity.ok(allUsers.stream()
                .map(userMapper::toDto)
                .toList());
    }
}
