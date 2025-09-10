package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.UserGateway;
import com.dev.Lyceum.API.core.usecases.user.CreateUserUsecase;
import com.dev.Lyceum.API.core.usecases.user.CreateUserUsecaseImpl;
import com.dev.Lyceum.API.core.usecases.user.ShowAllUsersUsecase;
import com.dev.Lyceum.API.core.usecases.user.ShowAllUsersUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfiguration {

    @Bean
    public CreateUserUsecase createUserUsecase(UserGateway gateway) {
        return new CreateUserUsecaseImpl(gateway);
    }

    @Bean
    public ShowAllUsersUsecase showAllUsersUsecase(UserGateway gateway) {
        return new ShowAllUsersUsecaseImpl(gateway);
    }
}
