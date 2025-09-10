package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.StudentGateway;
import com.dev.Lyceum.API.core.usecases.student.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentBeanConfiguration {

    @Bean
    public RegisterStudentUsecase registerStudentUsecase(StudentGateway gateway) {
        return new RegisterStudentUsecaseImpl(gateway);
    }

    @Bean
    public AssignEnrollmentToStudentUsecase assignEnrollmentToStudentUsecase(StudentGateway gateway) {
        return new AssignEnrollmentToStudentUsecaseImpl(gateway);
    }

    @Bean
    public ShowAllStudentsUsecase showAllStudentsUsecase(StudentGateway gateway) {
        return new ShowAllStudentsUsecaseImpl(gateway);
    }
}
