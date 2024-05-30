CREATE SEQUENCE IF NOT EXISTS broths_pk_sequence;

CREATE TABLE IF NOT EXISTS broths (
    id integer default nextval('broths_pk_sequence'),
    image_inactive varchar(128),
    image_active varchar(128),
    name varchar(128),
    description varchar(512),
    price numeric,

    primary key(id)
);