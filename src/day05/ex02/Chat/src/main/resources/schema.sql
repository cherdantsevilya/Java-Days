DROP TABLE IF EXISTS "User", "Chatroom", "Message";

CREATE TABLE IF NOT EXISTS "User" (
    id SERIAL PRIMARY KEY,
    login TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS "Chatroom" (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    owner INT NOT NULL REFERENCES "User"(id)
);

CREATE TABLE IF NOT EXISTS "Message" (
    id SERIAL PRIMARY KEY,
    author INT NOT NULL REFERENCES "User"(id),
    room INT NOT NULL REFERENCES "Chatroom"(id),
    text TEXT NOT NULL,
    localDateTime TIMESTAMP NOT NULL
);