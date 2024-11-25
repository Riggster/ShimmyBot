CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists role_assignments cascade;
drop table if exists roles cascade;
drop table if exists users cascade;

CREATE TABLE users (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE roles (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE role_assignments (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    assigned_on TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    revoked_on TIMESTAMP WITH TIME ZONE,
    CONSTRAINT fk_role_assignments_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role_assignments_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);