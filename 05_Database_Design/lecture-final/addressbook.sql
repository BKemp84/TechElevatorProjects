DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;

CREATE TABLE person (
        person_id serial primary key,
        first_name varchar(20) not null,
        last_name varchar(20) not null
);

CREATE TABLE address (
        address_id serial primary key,
        street varchar(30),
        line_two varchar(30),
        city varchar(20),
        postal_code varchar(20),
        district varchar(100),
        address_type varchar(30),
        type_other_description varchar(32),
        
        CONSTRAINT chk_address_type CHECK ( address_type IN ('Work', 'Shipping', 'Home', 'Billing', 'Other') ),
        
        CONSTRAINT chk_address_type_other CHECK ( (address_type = 'Other' AND type_other_description IS NOT NULL) OR 
                ( address_type <> 'Other' AND type_other_description IS NULL)  ) 

);

CREATE TABLE person_address ( 
        person_id int,
        address_id int,
        
        PRIMARY KEY(person_id, address_id),
        CONSTRAINT fk_person_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
        CONSTRAINT fk_address_address_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE phone (
        phone_id serial primary key,
        person_id int not null,
        phone_number varchar(20) not null,
        extension varchar(10),
        phone_type varchar(10),
        type_other_description varchar(32),
        
        CONSTRAINT fk_phone_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
        CONSTRAINT chk_phone_type CHECK ( phone_type IN ('Work', 'Home', 'Mobile', 'Other') ),
        
        CONSTRAINT chk_phone_type_other CHECK ( (phone_type = 'Other' AND type_other_description IS NOT NULL) OR 
                ( phone_type <> 'Other' AND type_other_description IS NULL)  ) 

);

CREATE TABLE email (
        email_id serial primary key,
        person_id int not null,
        email varchar(255) not null,
        email_type varchar(10),
        type_other_description varchar(32),
        
        CONSTRAINT fk_email_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
        CONSTRAINT chk_email_type CHECK ( email_type IN ('Work', 'Home','Other') ),
        
        CONSTRAINT chk_email_type_other CHECK ( (email_type = 'Other' AND type_other_description IS NOT NULL) OR 
                ( email_type <> 'Other' AND type_other_description IS NULL)  ) 

);

 