CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id varchar(64) default uuid_generate_v4(),
    api_key varchar(128),
    name varchar(128),
    usage_quota integer default 0,

    primary key (id)
);

CREATE SEQUENCE IF NOT EXISTS user_usages_pk_sequence;

CREATE TABLE user_usages (
    id integer default nextval('user_usages_pk_sequence'),
    date date,
    usage integer,
    user_id varchar(64),

    primary key (id),
    foreign key (user_id) references users(id)
);