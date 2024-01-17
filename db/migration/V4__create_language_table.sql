CREATE TABLE IF NOT EXISTS bookschema.language (
                          id INTEGER PRIMARY KEY  GENERATED ALWAYS AS IDENTITY,
                          name VARCHAR(255) NOT NULL,
                          code VARCHAR(255) NOT NULL
);