package com.dev.Lyceum.API.infra.persistence;

import com.dev.Lyceum.API.core.domain.StatusSubject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject_registration")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false)
    private EnrollmentEntity enrollment;

    private String grade;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "status_subject_enum")
    private StatusSubject statusSubject;
}
