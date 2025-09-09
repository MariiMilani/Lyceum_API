package com.dev.Lyceum.API.infra.persistence.repositories;

import com.dev.Lyceum.API.infra.persistence.EnrollmentEntity;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, String> {

    @Query("SELECT s FROM StudentEntity s JOIN FETCH s.user WHERE s.id = :id")
    Optional<StudentEntity> findByStudentId(@Param("id") Long studentId);

    @Query("SELECT e FROM EnrollmentEntity e JOIN FETCH e.student s JOIN FETCH s.user WHERE e.id = :id")
    Optional<EnrollmentEntity> findByIdWithStudentAndUser(@Param("id") String id);
}
