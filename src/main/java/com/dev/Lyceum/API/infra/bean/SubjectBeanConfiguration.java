package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.SubjectGateway;
import com.dev.Lyceum.API.core.usecases.subject.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectBeanConfiguration {

    @Bean
    public CreateSubjectUsecase createSubjectUsecase(SubjectGateway gateway) {
        return new CreateSubjectUsecaseImpl(gateway);
    }

    @Bean
    public ShowAllSubjectsUsecase showAllSubjectsUsecase(SubjectGateway gateway) {
        return new ShowAllSubjectsUsecaseImpl(gateway);
    }

    @Bean
    public ShowSubjectByIdUsecase showSubjectByIdUsecase(SubjectGateway gateway) {
        return new ShowSubjectByIdUsecaseImpl(gateway);
    }
}
