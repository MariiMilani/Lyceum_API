package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.SubjectGateway;
import com.dev.Lyceum.API.core.usecases.subject.CreateSubjectUsecase;
import com.dev.Lyceum.API.core.usecases.subject.CreateSubjectUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectBeanConfiguration {

    @Bean
    public CreateSubjectUsecase createSubjectUsecase(SubjectGateway subjectGateway) {
        return new CreateSubjectUsecaseImpl(subjectGateway);
    }
}
