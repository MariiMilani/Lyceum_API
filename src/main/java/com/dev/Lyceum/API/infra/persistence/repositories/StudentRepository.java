package com.dev.Lyceum.API.infra.persistence.repositories;

import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s JOIN FETCH s.user WHERE s.id = :id")
    Optional<StudentEntity> findByIdWithUser(@Param("id") Long id);
}
