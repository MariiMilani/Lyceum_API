package com.dev.Lyceum.API.core.domain.users;

import java.time.LocalDate;

public record User (Long id,
                    String name,
                    String email,
                    String identifier,
                    LocalDate createdAt) {
}
