CREATE TABLE IF NOT EXISTS bookschema.author (
                        id INTEGER PRIMARY KEY  GENERATED ALWAYS AS IDENTITY,
                        name VARCHAR(255) NOT NULL
);