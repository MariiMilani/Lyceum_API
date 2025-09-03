package com.dev.Lyceum.API.infra.mapper;

import com.dev.Lyceum.API.core.domain.users.Student;
import com.dev.Lyceum.API.infra.presentention.dto.StudentDto;

public class StudentMapperDTO {

    public Student toDomain (StudentDto request){
        return new Student(request.id(), request.user(), request.studentIdentifier(), request.isActive());
    }

    public StudentDto toDto (Student student){
        return new StudentDto(student.id(), student.user(), student.studentIdentifier(), student.isActive());
    }
}
