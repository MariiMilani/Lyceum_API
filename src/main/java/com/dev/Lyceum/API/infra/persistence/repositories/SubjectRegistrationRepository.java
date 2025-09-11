package com.dev.Lyceum.API.infra.persistence.repositories;

import com.dev.Lyceum.API.infra.persistence.SubjectRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Query("SELECT s FROM SubjectRegistrationEntity s JOIN FETCH s.subject WHERE s.subject.id = :subjectId")
    Optional<List<SubjectRegistrationEntity>> findAllRegistrationBySubject(@Param("subjectId") Long subjectId);

    @Query("SELECT s FROM SubjectRegistrationEntity s JOIN FETCH s.enrollment WHERE s.enrollment.id = :enrollmentId")
    Optional<List<SubjectRegistrationEntity>> findAllRegistrationByEnrollment(@Param("enrollmentId") String enrollmentId);
}
