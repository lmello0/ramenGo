CREATE SEQUENCE IF NOT EXISTS ramens_pk_sequence;

CREATE TABLE IF NOT EXISTS ramens (
        id integer default nextval('ramens_pk_sequence'),
        description varchar(512),
        image varchar(128),
        broth_id integer,
        protein_id integer,

        primary key (id),
        foreign key (broth_id) references broths(id),
        foreign key (protein_id) references proteins(id)
);