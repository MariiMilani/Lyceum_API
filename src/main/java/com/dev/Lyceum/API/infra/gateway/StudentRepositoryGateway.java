package com.dev.Lyceum.API.infra.gateway;

import com.dev.Lyceum.API.core.domain.Enrollment;
import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.core.gateway.StudentGateway;
import com.dev.Lyceum.API.infra.exception.EntityNotFoundException;
import com.dev.Lyceum.API.infra.mapper.EnrollmentMapper;
import com.dev.Lyceum.API.infra.mapper.StudentMapper;
import com.dev.Lyceum.API.infra.persistence.StudentEntity;
import com.dev.Lyceum.API.infra.persistence.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<Student> showAllStudents() {
        return repository.findAll().stream()
                .map(studentMapper::entityToDomain)
                .toList();
    }

    @Override
    public Student showStudentById(Long id) {
        StudentEntity studentById = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        return studentMapper.entityToDomain(studentById);
    }


}
