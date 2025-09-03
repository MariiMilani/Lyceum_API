package com.dev.Lyceum.API.infra.persistence.repositories;

import com.dev.Lyceum.API.infra.persistence.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
