CREATE TABLE student(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    user_id BIGSERIAL NOT NULL,
    enrollment_id VARCHAR(16) UNIQUE,
    is_active BOOLEAN NOT NULL DEFAULT true,
    CONSTRAINT fk_student_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_student_enrollment FOREIGN KEY (enrollment_id) REFERENCES enrollment(id) ON DELETE SET NULL
);