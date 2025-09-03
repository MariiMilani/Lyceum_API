package com.dev.Lyceum.API.infra.presentention.dto;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.User;

public record StudentDto(Long id,
                         User user,
                         Enrollment studentIdentifier,
                         boolean isActive) {
}
