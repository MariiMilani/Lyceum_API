package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;
import com.dev.Lyceum.API.core.usecases.enrollment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnrollmentBeanConfiguration {

    @Bean
    public CreateEnrollmentUsecase createEnrollmentUsecase(EnrollmentGateway gateway) {
        return new CreateEnrollmentUsecaseImpl(gateway);
    }

    @Bean
    public ShowAllEnrollmentsUsecase showAllEnrollmentsUsecase(EnrollmentGateway gateway) {
        return new ShowAllEnrollmentsUsecaseImpl(gateway);
    }

    @Bean
    public DeleteEnrollmentByIdUsecase deleteEnrollmentByIdUsecase(EnrollmentGateway gateway) {
        return new DeleteEnrollmentByIdUsecaseImpl(gateway);
    }

    @Bean
    public ShowEnrollmentByIdUsecase showEnrollmentByIdUsecase(EnrollmentGateway gateway) {
        return new ShowEnrollmentByIdUsecaseImpl(gateway);
    }
}
