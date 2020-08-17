-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name
FROM country;

-- Selecting the name and population of all countries
SELECT name, population FROM country;

-- Selecting all columns from the city table
SELECT * FROM city;

SELECT DISTINCT district FROM city;

SELECT name AS city_name FROM city;



-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT * 
FROM city
WHERE district = 'Ohio';

-- Selecting countries that gained independence in the year 1776
SELECT * 
FROM country
WHERE indepyear = 1776;

-- Selecting countries not in Asia
SELECT * FROM country WHERE continent != 'Asia';

-- Selecting countries that do not have an independence year
SELECT * FROM country WHERE indepyear IS NULL;


-- Selecting countries that do have an independence year
SELECT * FROM country WHERE indepyear IS NOT NULL;

-- Selecting countries that have a population greater than 5 million
SELECT * FROM country WHERE population > 5000000;


-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT * 
FROM city
WHERE district = 'Ohio' AND population > 400000;

SELECT * 
FROM city
WHERE (district = 'Ohio' OR district = 'New York') AND population > 400000;


-- Selecting country names on the continent North America or South America
SELECT name FROM country WHERE continent = 'North America' OR continent = 'South America';

SELECT name FROM country WHERE continent IN ('North America', 'South America');

SELECT name FROM country WHERE continent NOT IN ('North America', 'South America');

-- LIKE
SELECT name from country WHERE continent LIKE '%America';

-- Get all cities where the name starts with A
SELECT * FROM city WHERE name LIKE 'A%';

-- All cities where the name ends with a
SELECT * FROM city WHERE name LIKE '%a';

-- All cities where the name contains the letter a, case insensitive
SELECT * FROM city WHERE name ILIKE '%a%';

-- All cities where the name contains a letter a followed by a letter m
SELECT * FROM city WHERE name ILIKE '%a%m%';


-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
SELECT name, population, lifeexpectancy, (population / surfacearea) AS density 
FROM country
WHERE continent = 'Asia'
AND surfacearea > 0;



