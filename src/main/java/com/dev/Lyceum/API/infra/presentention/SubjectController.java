package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.usecases.subject.CreateSubjectUsecase;
import com.dev.Lyceum.API.core.usecases.subject.ShowAllSubjectsUsecase;
import com.dev.Lyceum.API.core.usecases.subject.ShowSubjectByIdUsecase;
import com.dev.Lyceum.API.infra.mapper.SubjectMapper;
import com.dev.Lyceum.API.infra.presentention.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private CreateSubjectUsecase createSubjectUsecase;

    @Autowired
    private ShowAllSubjectsUsecase showAllSubjectsUsecase;

    @Autowired
    private ShowSubjectByIdUsecase showSubjectByIdUsecase;

    @PostMapping("/create")
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        Subject newSubject = createSubjectUsecase.execute(subjectMapper.dtoToDomain(subjectDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subjectMapper.toDto(newSubject));
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> showAllSubjects() {
        List<Subject> allSubjects = showAllSubjectsUsecase.execute();
        return ResponseEntity.ok(allSubjects.stream().map(subjectMapper::toDto).toList());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<SubjectDto> showSubjectById(@PathVariable Long id) {
        Subject subjectById = showSubjectByIdUsecase.execute(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(subjectMapper.toDto(subjectById));
    }
}
