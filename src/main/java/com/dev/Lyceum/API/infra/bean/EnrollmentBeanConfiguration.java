package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.EnrollmentGateway;
import com.dev.Lyceum.API.core.usecases.enrollment.CreateEnrollmentUsecase;
import com.dev.Lyceum.API.core.usecases.enrollment.CreateEnrollmentUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnrollmentBeanConfiguration {

    @Bean
    public CreateEnrollmentUsecase createEnrollmentUsecase(EnrollmentGateway enrollmentGateway) {
        return new CreateEnrollmentUsecaseImpl(enrollmentGateway);
    }
}
