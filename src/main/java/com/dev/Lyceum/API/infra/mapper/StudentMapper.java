package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.infra.persistence.EnrollmentEntity;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.EnrollmentRepository;
import com.dev.Lyceum.API.infra.presentention.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    public Student dtoToDomain(StudentDto request) {
        if (request.studentIdentifier() != null) {
            return new Student(request.id(), userMapper.dtoToDomain(request.user()), request.studentIdentifier(), request.isActive());
        }
        return new Student(request.id(), userMapper.dtoToDomain(request.user()), null, request.isActive());
    }

    public Student entityToDomain(StudentEntity entity) {
        if (entity.getStudentIdentifier() != null) {
            return new Student(entity.getId(), userMapper.entityToDomain(entity.getUser()), entity.getStudentIdentifier().getId(), entity.isActive());
        }
        return new Student(entity.getId(), userMapper.entityToDomain(entity.getUser()), null, entity.isActive());
    }

    public StudentDto toDto(Student student) {
        if (student.studentIdentifier() != null) {
            return new StudentDto(student.id(), userMapper.toDto(student.user()), student.studentIdentifier(), student.isActive());
        }
        return new StudentDto(student.id(), userMapper.toDto(student.user()), null, student.isActive());
    }

    public StudentEntity toEntity(Student student) {
        if (student.studentIdentifier() != null) {
            Optional<EnrollmentEntity> enrollment = getEnrollment(student.studentIdentifier());
            if (enrollment.isPresent()) {
                return new StudentEntity(student.id(), userMapper.toEntity(student.user()), enrollment.get(), student.isActive());
            }
        }
        return new StudentEntity(student.id(), userMapper.toEntity(student.user()), null, student.isActive());
    }

    private Optional<EnrollmentEntity> getEnrollment(String id) {
        return enrollmentRepository.findById(id);
    }

}
