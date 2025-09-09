package com.dev.Lyceum.API.infra.utils;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.util.IdGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Year;
import java.util.UUID;

public class EnrollmentIdGenerator extends SequenceStyleGenerator {

    @Override
    public String generate(SharedSessionContractImplementor session, Object object) {
        String prefix = Year.now().toString();
        String uuid = UUID.randomUUID().toString().replace("-","").substring(0, 12);

        return prefix + uuid;
    }

    @Override
    public boolean allowAssignedIdentifiers(){
        return true;
    }

    @IdGeneratorType(EnrollmentIdGenerator.class)
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD})
    public @interface EnrollmentId {
    }
}
