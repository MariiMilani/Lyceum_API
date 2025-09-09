package com.dev.Lyceum.API.infra.persistence;

import com.dev.Lyceum.API.infra.utils.EnrollmentIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "enrollment")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnrollmentEntity {

    @Id
    @Column(length = 16)
    @EnrollmentIdGenerator.EnrollmentId
    private String id;

    @OneToOne(mappedBy = "studentIdentifier")
    @JsonIgnore
    private StudentEntity student;

    @OneToMany(mappedBy = "enrollment")
    private List<SubjectRegistrationEntity> subjects;
}
