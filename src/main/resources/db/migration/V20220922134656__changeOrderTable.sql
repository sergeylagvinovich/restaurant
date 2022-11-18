ALTER TABLE orders
    ADD order_date timestamp NULL;

ALTER TABLE order_statuses
    ADD priority int4 NULL;