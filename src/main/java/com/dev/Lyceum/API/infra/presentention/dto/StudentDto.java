package com.dev.Lyceum.API.infra.presentention.dto;

public record StudentDto(Long id,
                         UserDto user,
                         String studentIdentifier,
                         boolean isActive) {
}
