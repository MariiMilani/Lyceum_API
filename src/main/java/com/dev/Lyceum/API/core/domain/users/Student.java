package com.dev.Lyceum.API.core.domain.users;

import com.dev.Lyceum.API.core.domain.Enrollment;

public class Student extends User{

    public Long id;

    public User idUser;

    public Enrollment studentIdentifier;

    public boolean isActive;
}
