package com.dev.Lyceum.API.infra.presentention;

import com.dev.Lyceum.API.core.domain.SubjectRegistration;
import com.dev.Lyceum.API.core.usecases.subjectRegistration.CreateRegistrationUsecase;
import com.dev.Lyceum.API.infra.mapper.SubjectRegistrationMapper;
import com.dev.Lyceum.API.infra.presentention.dto.SubjectRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class SubjectRegistrationController {

    @Autowired
    private CreateRegistrationUsecase createRegistrationUsecase;
    @Autowired
    public SubjectRegistrationMapper subjectRegistrationMapper;

    @PostMapping("/create")
    public ResponseEntity<SubjectRegistrationDto> createRegistration(@RequestBody SubjectRegistrationDto dto) {
        SubjectRegistration newRegistration = createRegistrationUsecase.execute(subjectRegistrationMapper.dtoToDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subjectRegistrationMapper.toDto(newRegistration));
    }
}
