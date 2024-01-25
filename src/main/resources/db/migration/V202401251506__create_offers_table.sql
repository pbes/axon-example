CREATE TABLE offers (
                         id varchar(255) NOT NULL,
                         user_id varchar(255) NOT NULL,
                         product varchar(255) NOT NULL,
                         type varchar(50) NOT NULL,
                         quantity NUMERIC(19, 2) NOT NULL DEFAULT 0.0,
                         price NUMERIC(19, 2) NOT NULL DEFAULT 0.0
);