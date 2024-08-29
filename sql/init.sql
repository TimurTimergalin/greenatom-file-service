CREATE TABLE files
(
    id            SERIAL PRIMARY KEY,
    title         TEXT      NOT NULL UNIQUE,
    creation_date TIMESTAMP NOT NULL,
    description   TEXT,
    content       TEXT      NOT NULL
);