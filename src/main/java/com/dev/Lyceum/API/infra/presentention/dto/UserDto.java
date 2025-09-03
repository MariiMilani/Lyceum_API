package com.dev.Lyceum.API.infra.presentention.dto;

import java.time.LocalDateTime;

public record UserDto(Long id,
                      String name,
                      String email,
                      String identifier,
                      LocalDateTime createdAt) {
}
