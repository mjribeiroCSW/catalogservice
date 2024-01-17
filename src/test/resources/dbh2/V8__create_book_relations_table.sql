CREATE TABLE IF NOT EXISTS book_author (
    book_id INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE IF NOT EXISTS book_format (
    book_id INT NOT NULL,
    format_id INT NOT NULL,
    PRIMARY KEY (book_id, format_id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (format_id) REFERENCES format(id)
);

CREATE TABLE IF NOT EXISTS book_genre (
    book_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (book_id, genre_id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (genre_id) REFERENCES genre(id)
);

CREATE TABLE IF NOT EXISTS book_language (
    book_id INT NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY (book_id, language_id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (language_id) REFERENCES language(id)
);