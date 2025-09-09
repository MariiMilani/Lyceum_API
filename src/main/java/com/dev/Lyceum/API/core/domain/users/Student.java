package com.dev.Lyceum.API.core.domain.users;

public record Student (Long id,
                       User user,
                       String studentIdentifier,
                       boolean isActive){
}
