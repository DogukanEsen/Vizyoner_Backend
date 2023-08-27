CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    firstname TEXT not null,
    lastname TEXT not null,
    email TEXT not null,
    password TEXT not null
);
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role_junction (
    user_id INT REFERENCES users (id),
    role_id INT REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);
CREATE TABLE IF NOT EXISTS company(
    id SERIAL PRIMARY KEY,
    name TEXT,
    content TEXT,
    category TEXT,
    type BOOLEAN,
    image TEXT,
    userID INT REFERENCES users (id)
);
CREATE TABLE IF NOT EXISTS advert (
    id SERIAL PRIMARY KEY,
    updateDate DATE,
    title TEXT,
    description TEXT,
    startDate DATE,
    endDate DATE,
    image TEXT,
    location TEXT,
    category TEXT,
    advertcategory TEXT,
    companyID INT REFERENCES company (id)
);

CREATE TABLE IF NOT EXISTS application (
    id SERIAL PRIMARY KEY,
    date DATE not null,
    content TEXT,
    file TEXT,
    userID INT REFERENCES users (id),
    advertID INT REFERENCES advert (id)
);

CREATE TABLE IF NOT EXISTS projects (
    id SERIAL PRIMARY KEY,
    title TEXT not null,
    content TEXT,
    thumbnail TEXT,
    image TEXT,
    githubLink TEXT,
    videoLink TEXT,
    userID INT REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS resume (
    id SERIAL PRIMARY KEY,
    category TEXT,
    phone TEXT,
    image TEXT,
    country TEXT,
    city TEXT,
    address TEXT,
    gpa double precision,
    grade TEXT,
    department TEXT,
    description TEXT,
    userID INT REFERENCES users (id)
);


