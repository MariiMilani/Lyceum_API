package com.dev.Lyceum.API.infra.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.Year;
import java.util.UUID;

public class EnrollmentIdGenerator implements IdentifierGenerator {

    public static final String generatorName = "EnrollmentIdGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        String prefix = Year.now().toString();
        String uuid = UUID.randomUUID().toString().replace("-","").substring(0, 12);

        return prefix + uuid;
    }
}
