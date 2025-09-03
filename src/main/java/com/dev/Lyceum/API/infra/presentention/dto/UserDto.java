package com.dev.Lyceum.API.infra.presentention.dto;

import java.time.LocalDate;

public record UserDto(Long id,
                      String name,
                      String email,
                      String identifier,
                      LocalDate createdAt) {
}
