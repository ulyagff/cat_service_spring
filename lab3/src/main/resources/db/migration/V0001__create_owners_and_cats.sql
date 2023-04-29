CREATE TABLE IF NOT EXISTS owners (
                        id SERIAL PRIMARY KEY,
                        name varchar(255) NOT NULL,
                        birthday date NOT NULL
);

CREATE TABLE cats (
                      id SERIAL PRIMARY KEY,
                      name varchar(255) NOT NULL,
                      birthday date NOT NULL,
                      breed varchar(255) NOT NULL,
                      color varchar(255) NOT NULL,
                      owner_id INTEGER REFERENCES owners(id) ON DELETE CASCADE
);