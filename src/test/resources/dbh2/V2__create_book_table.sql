CREATE TABLE IF NOT EXISTS book (
                      id INTEGER PRIMARY KEY  AUTO_INCREMENT,
                      original_title VARCHAR(255) NOT NULL,
                      isbn VARCHAR(255),
                      release_date TIMESTAMP,
                      edition_date TIMESTAMP,
                      edition VARCHAR(255),
                      series BOOLEAN,
                      synopsis TEXT,
                      price FLOAT NOT NULL,
                      promotional_price FLOAT,
                      stock_available INT NOT NULL,
                      date_created TIMESTAMP NOT NULL,
                      date_updated TIMESTAMP,
                      availability INT,
                      publisher_id INT REFERENCES publisher(id),
                      CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id) ON DELETE CASCADE
);