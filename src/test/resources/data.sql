CREATE TABLE IF NOT EXISTS TB_USER(
    id int primary key,
    email varchar(100),
    password varchar(100)
);

INSERT INTO TB_USER
VALUES      (1,
             'abc@gmail.com',
             '$2a$10$i.lAnlDVNBZ4JX3Yrh7aueROCGZwHaOUJwHw/Vj6a/BKm6YzwBEHq');