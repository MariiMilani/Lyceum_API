package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.gateway.StudentGateway;
import com.dev.Lyceum.API.infra.mapper.EnrollmentMapper;
import com.dev.Lyceum.API.infra.mapper.StudentMapper;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.UserEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.StudentRepository;
import com.dev.Lyceum.API.infra.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentRepositoryGateway implements StudentGateway {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public Student registerStudent(Student student) {
        StudentEntity newStudent = studentMapper.toEntity(student);
        repository.save(newStudent);
        return studentMapper.entityToDomain(newStudent);
    }

    @Override
    public void assignEnrollment(Student student, Enrollment enrollment) {
        StudentEntity studentEntity = studentMapper.toEntity(student);
        studentEntity.setStudentIdentifier(enrollmentMapper.toEntity(enrollment, studentEntity));

        repository.save(studentEntity);
    }


}
