CREATE TABLE IF NOT EXISTS bookschema.tag (
                     id INTEGER PRIMARY KEY  GENERATED ALWAYS AS IDENTITY,
                     name VARCHAR(255) NOT NULL,
                     book_id INT,
                     FOREIGN KEY (book_id) REFERENCES bookschema.book(id)
);