package com.dev.Lyceum.API.infra.persistence.repositories;

import com.dev.Lyceum.API.infra.persistence.SubjectRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SubjectRegistrationRepository extends JpaRepository<SubjectRegistrationEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO subject_registration (subject_id, enrollment_id, grade, status_subject)" +
            "VALUES (:subjectId, :enrollmentId, :grade, CAST(:statusSubject AS status_subject_enum))", nativeQuery = true)
    void insertSubjectRegistration(
            @Param("subjectId") Long subjectId,
            @Param("enrollmentId") String enrollmentId,
            @Param("grade") String grade,
            @Param("statusSubject") String statusSubject
    );
}
