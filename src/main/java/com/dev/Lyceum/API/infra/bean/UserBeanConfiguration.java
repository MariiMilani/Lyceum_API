package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.UserGateway;
import com.dev.Lyceum.API.core.usecases.user.CreateUserUsecase;
import com.dev.Lyceum.API.core.usecases.user.CreateUserUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfiguration {

    @Bean
    public CreateUserUsecase createUserUsecase(UserGateway userGateway) {
        return new CreateUserUsecaseImpl(userGateway);
    }
}
