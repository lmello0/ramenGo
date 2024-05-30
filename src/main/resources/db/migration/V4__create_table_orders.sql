CREATE SEQUENCE IF NOT EXISTS orders_pk_sequence;

CREATE TABLE IF NOT EXISTS orders (
    id integer default nextval('orders_pk_sequence'),
    ramen_id integer,

    primary key (id),
    foreign key (ramen_id) references ramens(id)
);