CREATE TABLE inventory (
    id SERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL
);