package com.dev.Lyceum.API.infra.persistence.repositories;

import com.dev.Lyceum.API.infra.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
