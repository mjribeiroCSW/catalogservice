CREATE TABLE IF NOT EXISTS tag (
                     id INTEGER PRIMARY KEY  AUTO_INCREMENT,
                     name VARCHAR(255) NOT NULL,
                     book_id INT,
                     FOREIGN KEY (book_id) REFERENCES book(id)
);