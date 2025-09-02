package com.dev.Lyceum.API.core.domain.users;

import java.time.LocalDateTime;

public record User (Long id,
                    String name,
                    String email,
                    String identifier,
                    LocalDateTime createdAt) {
}
