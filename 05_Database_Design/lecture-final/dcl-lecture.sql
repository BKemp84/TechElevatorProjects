SELECT * FROM person;

-- Create a new User with a Password
CREATE USER warthog WITH PASSWORD '123';

-- Grant SELECT ON a table to a user
GRANT SELECT ON person TO warthog;


-- Grant INSERT ON a table to a user
INSERT INTO person (first_name, last_name) VALUES ('John', 'Fulton');
GRANT INSERT ON person TO warthog;

-- Grant SELECT ON a sequence to a user
GRANT USAGE, SELECT ON SEQUENCE person_person_id_seq TO warthog;

-- Revoke SELECT ON a table from a user
REVOKE SELECT ON person FROM warthog;