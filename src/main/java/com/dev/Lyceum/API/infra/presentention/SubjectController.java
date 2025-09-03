package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.usecases.subject.CreateSubjectUsecase;
import com.dev.Lyceum.API.infra.mapper.SubjectMapper;
import com.dev.Lyceum.API.infra.presentention.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private CreateSubjectUsecase createSubjectUsecase;

    @PostMapping("/create")
    public ResponseEntity<SubjectDto> createSubject (@RequestBody SubjectDto subjectDto){
        Subject newSubject = createSubjectUsecase.execute(subjectMapper.dtoToDomain(subjectDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subjectMapper.toDto(newSubject));
    }
}
