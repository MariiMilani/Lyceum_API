package com.dev.Lyceum.API.core.gateway;

import com.dev.Lyceum.API.core.domain.Subject;

import java.util.List;

public interface SubjectGateway {

    Subject createSubject(Subject subject);

    List<Subject> showAllSubjects();

    Subject showSubjectById(Long id);
}
