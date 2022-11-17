-- DROP SEQUENCE public.card_dishes_id_seq;

CREATE SEQUENCE public.card_dishes_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.cards_id_seq;

CREATE SEQUENCE public.cards_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.dish_products_id_seq;

CREATE SEQUENCE public.dish_products_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.dish_types_id_seq;

CREATE SEQUENCE public.dish_types_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.dishes_id_seq;

CREATE SEQUENCE public.dishes_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.documents_id_seq;

CREATE SEQUENCE public.documents_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.order_statuses_id_seq;

CREATE SEQUENCE public.order_statuses_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.orders_id_seq;

CREATE SEQUENCE public.orders_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.partners_id_seq;

CREATE SEQUENCE public.partners_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.products_id_seq;

CREATE SEQUENCE public.products_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.roles_id_seq;

CREATE SEQUENCE public.roles_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.units_id_seq;

CREATE SEQUENCE public.units_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.user_roles_id_seq;

CREATE SEQUENCE public.user_roles_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.users_id_seq;

CREATE SEQUENCE public.users_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;

-- public.users definition

-- Drop table

-- DROP TABLE users;

CREATE TABLE users (
                       id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                       email varchar(255) NULL,
                       is_active bool NULL,
                       "name" varchar(255) NULL,
                       "password" varchar(255) NULL,
                       phone varchar(255) NULL,
                       user_name varchar(255) NULL,
                       CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- public.cards definition

-- Drop table

-- DROP TABLE cards;

CREATE TABLE cards (
                       id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                       created_at timestamp NULL,
                       updated_at timestamp NULL,
                       in_order bool NULL,
                       updated_user int4 NULL,
                       CONSTRAINT cards_pkey PRIMARY KEY (id),
                       CONSTRAINT fks80g7lsefaejrpievy3rglkm5 FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.dish_types definition

-- Drop table

-- DROP TABLE dish_types;

CREATE TABLE dish_types (
                            id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                            created_at timestamp NULL,
                            updated_at timestamp NULL,
                            "name" varchar(255) NULL,
                            updated_user int4 NULL,
                            CONSTRAINT dish_types_pkey PRIMARY KEY (id),
                            CONSTRAINT fkdvw7gh3pjqfpnw86q8pby77ov FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.dishes definition

-- Drop table

-- DROP TABLE dishes;

CREATE TABLE dishes (
                        id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                        created_at timestamp NULL,
                        updated_at timestamp NULL,
                        "name" varchar(255) NULL,
                        "img_path" varchar(255) NULL,
                        price varchar(255) NULL,
                        updated_user int4 NULL,
                        dish_type_id int4 NULL,
                        CONSTRAINT dishes_pkey PRIMARY KEY (id),
                        CONSTRAINT fk7wpu8k8lv47nyn4owuvda1lq8 FOREIGN KEY (dish_type_id) REFERENCES dish_types(id),
                        CONSTRAINT fkd1048t4mw75rngtmdt7tyrw38 FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.documents definition

-- Drop table

-- DROP TABLE documents;

CREATE TABLE documents (
                           id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                           created_at timestamp NULL,
                           updated_at timestamp NULL,
                           file_path varchar(255) NULL,
                           "name" varchar(255) NULL,
                           updated_user int4 NULL,
                           CONSTRAINT documents_pkey PRIMARY KEY (id),
                           CONSTRAINT fk79pj7gtn2xtsymk5xqdr4igje FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.order_statuses definition

-- Drop table

-- DROP TABLE order_statuses;

CREATE TABLE order_statuses (
                                id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                                created_at timestamp NULL,
                                updated_at timestamp NULL,
                                "name" varchar(255) NULL,
                                updated_user int4 NULL,
                                CONSTRAINT order_statuses_pkey PRIMARY KEY (id),
                                CONSTRAINT fk3o3v493uxnvgtfsoiuexpcea FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.orders definition

-- Drop table

-- DROP TABLE orders;

CREATE TABLE orders (
                        id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                        created_at timestamp NULL,
                        updated_at timestamp NULL,
                        address varchar(255) NULL,
                        need_call bool NULL,
                        phone varchar(255) NULL,
                        updated_user int4 NULL,
                        card_id int4 NULL,
                        document_id int4 NULL,
                        order_status_id int4 NULL,
                        CONSTRAINT orders_pkey PRIMARY KEY (id),
                        CONSTRAINT fk182cwld4k6c8k1l0xdngrpkfk FOREIGN KEY (document_id) REFERENCES documents(id),
                        CONSTRAINT fk7ump3dhga2b2bsr1xa8d6tky4 FOREIGN KEY (card_id) REFERENCES cards(id),
                        CONSTRAINT fkcbbqf26brulgfgvd0mf74rv4y FOREIGN KEY (order_status_id) REFERENCES order_statuses(id),
                        CONSTRAINT fkptfem9bqp3lg5n336eu4p0yrd FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.partners definition

-- Drop table

-- DROP TABLE partners;

CREATE TABLE partners (
                          id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                          created_at timestamp NULL,
                          updated_at timestamp NULL,
                          address varchar(255) NULL,
                          full_name varchar(255) NULL,
                          legal_address varchar(255) NULL,
                          short_name varchar(255) NULL,
                          unp varchar(255) NULL,
                          updated_user int4 NULL,
                          CONSTRAINT partners_pkey PRIMARY KEY (id),
                          CONSTRAINT fkij1flc5rvqjeaqtywh3tyu3ws FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.roles definition

-- Drop table

-- DROP TABLE roles;

CREATE TABLE roles (
                       id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                       created_at timestamp NULL,
                       updated_at timestamp NULL,
                       "name" varchar(255) NULL,
                       updated_user int4 NULL,
                       CONSTRAINT roles_pkey PRIMARY KEY (id),
                       CONSTRAINT fkouvwf7ee51nqvl6e5yb4n2j7 FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.units definition

-- Drop table

-- DROP TABLE units;

CREATE TABLE units (
                       id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                       created_at timestamp NULL,
                       updated_at timestamp NULL,
                       "name" varchar(255) NULL,
                       updated_user int4 NULL,
                       CONSTRAINT units_pkey PRIMARY KEY (id),
                       CONSTRAINT fk6cu2qs9huuntqlqnm6t6ggo6h FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.user_roles definition

-- Drop table

-- DROP TABLE user_roles;

CREATE TABLE user_roles (
                            id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                            can_delete bool NULL,
                            can_insert bool NULL,
                            can_update bool NULL,
                            can_view bool NULL,
                            role_id int4 NULL,
                            user_id int4 NULL,
                            CONSTRAINT user_roles_pkey PRIMARY KEY (id),
                            CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES roles(id),
                            CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users(id)
);


-- public.card_dishes definition

-- Drop table

-- DROP TABLE card_dishes;

CREATE TABLE card_dishes (
                             id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                             created_at timestamp NULL,
                             updated_at timestamp NULL,
                             count int4 NULL,
                             updated_user int4 NULL,
                             card_id int4 NULL,
                             dish_id int4 NULL,
                             CONSTRAINT card_dishes_pkey PRIMARY KEY (id),
                             CONSTRAINT fk4xiees2t5qx1pebtbkmcb93tw FOREIGN KEY (dish_id) REFERENCES dishes(id),
                             CONSTRAINT fk7vs1rgx0tsr0j57g90oc9yh2m FOREIGN KEY (card_id) REFERENCES cards(id),
                             CONSTRAINT fkho8ld2qd9wokqyys0rvffpxgd FOREIGN KEY (updated_user) REFERENCES users(id)
);


-- public.products definition

-- Drop table

-- DROP TABLE products;

CREATE TABLE products (
                          id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                          created_at timestamp NULL,
                          updated_at timestamp NULL,
                          count_in_store float4 NULL,
                          "name" varchar(255) NULL,
                          updated_user int4 NULL,
                          unit_id int4 NULL,
                          CONSTRAINT products_pkey PRIMARY KEY (id),
                          CONSTRAINT fk7rwiiom56cb2836yq4akiahep FOREIGN KEY (updated_user) REFERENCES users(id),
                          CONSTRAINT fkeex0i50vfsa5imebrfdiyhmp9 FOREIGN KEY (unit_id) REFERENCES units(id)
);


-- public.dish_products definition

-- Drop table

-- DROP TABLE dish_products;

CREATE TABLE dish_products (
                               id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                               created_at timestamp NULL,
                               updated_at timestamp NULL,
                               order_num int4 NULL,
                               "text" varchar(255) NULL,
                               updated_user int4 NULL,
                               dish_id int4 NULL,
                               product_id int4 NULL,
                               CONSTRAINT dish_products_pkey PRIMARY KEY (id),
                               CONSTRAINT fkevnx0cl1odw6g1iuu11t5g9t6 FOREIGN KEY (updated_user) REFERENCES users(id),
                               CONSTRAINT fkmpt6xhlowhkqbwm43jc8ryjmp FOREIGN KEY (product_id) REFERENCES products(id),
                               CONSTRAINT fkp4yf5tp6j7liejhfqj0ncy9tk FOREIGN KEY (dish_id) REFERENCES dishes(id)
);


-- public.partners_products definition

-- Drop table

-- DROP TABLE partners_products;

CREATE TABLE partners_products (
                                   partner_id int4 NOT NULL,
                                   products_id int4 NOT NULL,
                                   CONSTRAINT partners_products_pkey PRIMARY KEY (partner_id, products_id),
                                   CONSTRAINT uk_m729glihy3gudotjki4p8633p UNIQUE (products_id),
                                   CONSTRAINT fknbbn4418pjmpynioaotardkod FOREIGN KEY (products_id) REFERENCES products(id),
                                   CONSTRAINT fkt90xt4ln1bmcedmukmoahiqnt FOREIGN KEY (partner_id) REFERENCES partners(id)
);
