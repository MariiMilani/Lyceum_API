package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;

import java.util.List;

public interface SubjectRegistrationGateway {

    SubjectRegistration createRegistration(SubjectRegistration registration);

    List<SubjectRegistration> allRegistrations();
}
