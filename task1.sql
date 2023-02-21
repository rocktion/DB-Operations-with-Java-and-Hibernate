CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    tc VARCHAR(11) NOT null UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE
);
 
CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    city VARCHAR(20) NOT NULL,
    district VARCHAR(20) NOT NULL,
    zip VARCHAR(10),
    open VARCHAR(120) NOT NULL,
    customer_id INTEGER NOT NULL REFERENCES customer(id)
);
 
CREATE TABLE phone (
    id SERIAL PRIMARY KEY,
    number VARCHAR(20) NOT NULL,
    customer_id INTEGER NOT NULL REFERENCES customer(id)
);
 
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    iban VARCHAR(30) NOT NULL,
    curreny_Type VARCHAR(15),
    balance INT ,
    last_transaction DATE,
    customer_id INTEGER  NOT NULL REFERENCES customer(id)
);


