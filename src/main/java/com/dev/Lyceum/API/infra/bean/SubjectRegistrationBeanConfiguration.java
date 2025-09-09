package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.CreateRegistrationUsecase;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.CreateRegistrationUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectRegistrationBeanConfiguration {

    @Bean
    public CreateRegistrationUsecase createRegistrationUsecase(SubjectRegistrationGateway gateway) {
        return new CreateRegistrationUsecaseImpl(gateway);
    }
}
