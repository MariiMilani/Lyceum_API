package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.infra.persistence.EnrollmentEntity;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.SubjectRegistrationEntity;
import com.dev.Lyceum.API.infra.presentention.dto.EnrollmentDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrollmentMapper {

    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    public EnrollmentMapper(@Lazy StudentMapper studentMapper, SubjectMapper subjectMapper) {
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
    }

    public Enrollment dtoToDomain(EnrollmentDto enrollmentDto) {
        return new Enrollment(enrollmentDto.id(), enrollmentDto.student(), enrollmentDto.subjects());
    }

    public Enrollment entityToDomain(EnrollmentEntity entity) {

        if (entity.getStudent() == null){
            throw new EntityNotFoundException("Student not found - EnrollmentMapper");
        }

        Enrollment domain = new Enrollment((entity.getId()), studentMapper.entityToDomain(entity.getStudent()), null);

        if (entity.getSubjects() == null){
            return domain;
        }
        List<SubjectRegistration> subjects = entity.getSubjects()
                .stream()
                .map(subject -> new SubjectRegistration(subject.getId(), subjectMapper.entityToDomain(subject.getSubject()), entity.getId(), subject.getGrade(), subject.getStatusSubject()))
                .toList();


        return new Enrollment((entity.getId()), studentMapper.entityToDomain(entity.getStudent()), subjects);
    }

    public EnrollmentDto toDto(Enrollment enrollment) {
        return new EnrollmentDto(enrollment.id(), enrollment.student(), enrollment.subjects());
    }

    public EnrollmentEntity toEntity(Enrollment enrollment, StudentEntity student) {

        EnrollmentEntity domain = new EnrollmentEntity((enrollment.id()), student, null);

        if (enrollment.subjects() != null){
            List<SubjectRegistrationEntity> subjects = enrollment.subjects()
                    .stream()
                    .map(subject -> new SubjectRegistrationEntity(subject.subject().id(), subjectMapper.toEntity(subject.subject()), domain, subject.grade(), subject.statusSubject()))
                    .toList();

            domain.setSubjects(subjects);
        }
        return domain;
    }
}
