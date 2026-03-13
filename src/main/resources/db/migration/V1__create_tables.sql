CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE table Users(
    id UUID primary key default gen_random_uuid(),
    name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    created_at timestamp default current_timestamp,
    enabled boolean default true
);

create table email_verification_tokens(
    id UUID primary key default gen_random_uuid(),
    otp varchar(6) not null,
    email varchar(255) not null,
    expiry timestamp not null,
    created_at timestamp default current_timestamp,
    verified boolean default false
 );