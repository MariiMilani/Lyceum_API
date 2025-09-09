package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;

public interface SubjectRegistrationGateway {

    SubjectRegistration createRegistration(SubjectRegistration registration);
}
