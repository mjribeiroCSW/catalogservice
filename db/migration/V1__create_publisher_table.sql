CREATE SCHEMA IF NOT EXISTS bookschema;

CREATE TABLE IF NOT EXISTS bookschema.publisher (
                           id INTEGER PRIMARY KEY  GENERATED ALWAYS AS IDENTITY,
                           name VARCHAR(255) NOT NULL
);