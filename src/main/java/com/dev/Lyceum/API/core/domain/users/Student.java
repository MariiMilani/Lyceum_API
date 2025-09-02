package com.dev.Lyceum.API.core.domain.users;

import com.dev.Lyceum.API.core.domain.Enrollment;

public record Student (Long id,
                       User user,
                       Enrollment studentIdentifier,
                       boolean isActive){
}
