-- These queries require the JOINS database

--INNER JOIN  (DEFAULT IF JUST USE JOIN)
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
JOIN two ON one.number = two.number; 

-- Complte the Inner Join Here


--LEFT JOIN  (Left Outer Join)
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
LEFT JOIN two ON one.number = two.number;
-- Complte the Left Join Here


--RIGHT JOIN  (Right Outer Join)
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
RIGHT JOIN two ON one.number = two.number;
-- Complte the Right Join Here


--FULL OUTER JOIN
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
FULL OUTER JOIN two ON one.number = two.number;
-- Complte the Full Outer Join Here


--Everything from ONLY the left table
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
LEFT JOIN two ON one.number = two.number
WHERE two.number IS NULL;
-- Complte the Join Here


--Everything from ONLY the right table
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
RIGHT JOIN two ON one.number = two.number
WHERE one.number IS NULL;
-- Complte the Join Here


--Everything in ONLY the Left or Right table, but not both
SELECT one.number AS one_number, one.description as one_description, two.number as two_number, two.description as two_description
FROM one
FULL OUTER JOIN two ON one.number = two.number
WHERE one.number IS NULL OR two.number IS NULL;
-- Complte the Join Here


--UNION
-- Create a Union between the two tables that shows all values from both in two columns








