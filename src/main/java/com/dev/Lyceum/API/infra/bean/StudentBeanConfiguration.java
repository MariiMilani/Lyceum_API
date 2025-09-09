package com.dev.Lyceum.API.infra.bean;

import com.dev.Lyceum.API.core.gateway.StudentGateway;
import com.dev.Lyceum.API.core.usecases.student.AssignEnrollmentToStudentUsecase;
import com.dev.Lyceum.API.core.usecases.student.AssignEnrollmentToStudentUsecaseImpl;
import com.dev.Lyceum.API.core.usecases.student.RegisterStudentUsecase;
import com.dev.Lyceum.API.core.usecases.student.RegisterStudentUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentBeanConfiguration {

    @Bean
    public RegisterStudentUsecase registerStudentUsecase(StudentGateway studentGateway) {
        return new RegisterStudentUsecaseImpl(studentGateway);
    }

    @Bean
    public AssignEnrollmentToStudentUsecase assignEnrollmentToStudentUsecase(StudentGateway studentGateway){
        return new AssignEnrollmentToStudentUsecaseImpl(studentGateway);
    }
}
