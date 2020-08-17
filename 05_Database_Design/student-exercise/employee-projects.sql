-- employee-projects
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS employee_project;
DROP TABLE IF EXISTS department;

CREATE DATABASE project_organizer;
  
     CREATE TABLE department( 
      department_id SERIAL primary key,
      department_name varchar (20) NOT NULL
      );
      
      CREATE TABLE employee(
         employee_id SERIAL primary key NOT NULL,
         job_title varchar (30) not null,
         last_name varchar(20) NOT NULL,
         first_name varchar(12),
         gender varchar(20),
         date_of_birth date  NOT NULL,
         date_of_hire date  NOT NULL,
         department_id int not NULL,
         
         
         CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES department(department_id)
        );
      
      CREATE TABLE  project(
      project_id SERIAL primary key,
      name varchar (30) NOT NULL,
      start_date varchar (12),
      employee_assigned int not null
      );
      
      CREATE TABLE employee_project ( 
       employee_id int, 
       project_id int,
       
       CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
       CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES project(project_id)
        );
        
 select *
 from department;
 select *
 from employee;
 select *
 from employee_project;
 select *
 from project;
 
 insert into department
 values (1, 'Keyboards');
 insert into department
 values (2, 'Guitars');
 insert into department
 values (3, 'Drums');
 insert into department
 values (4, 'P.A. & Mics');
 
 insert into employee
 values (1,'Sales', 'Lovins', 'Mike', 'M', '11-05-1977', '5-15-1997', 1);
 insert into employee
 values (2,'Sales', 'Stalter', 'Phil', 'M', '12-30-1977', '6-15-2000', 2);
 insert into employee
 values (3,'Sales', 'Stevens', 'Brad', 'M', '11-30-1981', '7-15-2010', 3);
 insert into employee
 values (4,'Sales', 'Mike', 'Close', 'M', '3-05-1987', '5-02-1997', 4);
 
 insert into employee
 values (5,'Manager', 'Webster', 'Terry', 'M', '4-05-1984', '5-15-1993', 1);
 insert into employee
 values (6,'Manager', 'Prince', 'Gary', 'M', '3-07-1996', '5-15-2018', 2);
 insert into employee
 values (7,'Manager', 'Varley', 'Barry', 'M', '2-012-1977', '5-15-1983', 3);
 insert into employee
 values (8,'Manager', 'Warthog', 'Mary', 'F', '1-4-1999', '5-15-74', 4);
 
 insert into project
 values (1, 'Club Disco', '5-15-2020', 8);
 insert into project
 values (2, 'School Of Rock', '1-15-2020', 2);
 insert into project
 values (3, 'Westerville HS Percussion', '2-15-2020', 7);
 insert into project
 values (4, 'Walmart P.A.', '3-15-2020', 4);
 
 insert into employee_project
 values (8,1);
 insert into employee_project
 values (2,2);
 insert into employee_project
 values (7,3);
 insert into employee_project
 values (4,4);
 