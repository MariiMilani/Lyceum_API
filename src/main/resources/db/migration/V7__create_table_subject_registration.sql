CREATE TABLE subject_registration(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    subject_id BIGSERIAL NOT NULL,
    enrollment_id VARCHAR(16) NOT NULL,
    grade VARCHAR(10),
    status_subject status_subject_enum,
    CONSTRAINT fk_subject_registration_subject FOREIGN KEY (subject_id) REFERENCES subject(id),
    CONSTRAINT fk_subject_registration_enrollment FOREIGN KEY (enrollment_id) REFERENCES enrollment(id)
);