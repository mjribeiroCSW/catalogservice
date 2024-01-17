CREATE TABLE IF NOT EXISTS bookschema.genre (
                       id INTEGER PRIMARY KEY  GENERATED ALWAYS AS IDENTITY,
                       name VARCHAR(255) NOT NULL
);