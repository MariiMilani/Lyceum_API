package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.SubjectRegistrationGateway;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectRegistrationBeanConfiguration {

    @Bean
    public CreateRegistrationUsecase createRegistrationUsecase(SubjectRegistrationGateway gateway) {
        return new CreateRegistrationUsecaseImpl(gateway);
    }

    @Bean
    public ShowAllRegistrationsUsecase showAllRegistrationsUsecase(SubjectRegistrationGateway gateway) {
        return new ShowAllRegistrationsUsecaseImpl(gateway);
    }

    @Bean
    public ShowRegistrationsBySubjectUsecase showRegistrationsBySubjectUsecase(SubjectRegistrationGateway gateway) {
        return new ShowRegistrationsBySubjectUsecaseImpl(gateway);
    }

    @Bean
    public ShowRegistrationsByEnrollmentUsecase showRegistrationsByEnrollmentUsecase(SubjectRegistrationGateway gateway) {
        return new ShowRegistrationsByEnrollmentUsecaseImpl(gateway);
    }
}
