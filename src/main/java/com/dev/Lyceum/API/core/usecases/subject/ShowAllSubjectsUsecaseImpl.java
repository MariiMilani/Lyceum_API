package com.dev.Lyceum.API.core.usecases.subject;

import com.dev.Lyceum.API.core.domain.Subject;
import com.dev.Lyceum.API.core.gateway.SubjectGateway;

import java.util.List;

public class ShowAllSubjectsUsecaseImpl implements ShowAllSubjectsUsecase {

    private final SubjectGateway subjectGateway;

    public ShowAllSubjectsUsecaseImpl(SubjectGateway subjectGateway) {
        this.subjectGateway = subjectGateway;
    }

    @Override
    public List<Subject> execute() {
        return subjectGateway.showAllSubjects();
    }
}
