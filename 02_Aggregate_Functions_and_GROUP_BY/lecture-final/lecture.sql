-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population
FROM country
ORDER BY population DESC;

--Names of countries and continents in ascending order
SELECT name, continent
FROM country
ORDER BY continent ASC, name DESC;


-- Columns in the Order By are ordered left to right
SELECT name, continent
FROM country
ORDER BY name DESC, continent ASC;

-- Results can be ordered by columns that appear on the table, but not in the results
SELECT name
FROM country
ORDER BY population DESC;


-- LIMITING RESULTS

SELECT name, population
FROM country
ORDER BY population DESC
LIMIT 5;

-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC
LIMIT 10;


-- CONCATENATING OUTPUTS

SELECT round(gnp / population, 4) AS gnp_percapita FROM country WHERE gnp > 0
ORDER BY gnp_percapita DESC;

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city

SELECT (name || ', ' || district) AS name_and_state
FROM city
WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy)
FROM country
WHERE lifeexpectancy IS NOT NULL;

SELECT round(AVG(lifeexpectancy)::decimal, 2)
FROM country
WHERE lifeexpectancy IS NOT NULL;

-- Total population in Ohio
SELECT SUM(population)
FROM city
WHERE district = 'Ohio';


-- The surface area of the smallest country in the world
SELECT MIN(surfacearea)
FROM country;

-- The surface area of the largest 
SELECT MAX(surfacearea)
FROM country;

-- The number of countries who declared independence in 1991
SELECT COUNT(*)
FROM country
WHERE indepyear = 1991;

-- The 10 largest countries in the world
SELECT name
FROM country
ORDER BY surfacearea DESC
LIMIT 10;

SELECT MIN(population), name FROM country
WHERE population > 0;


-- GROUP BY


-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) AS countries
FROM countrylanguage
GROUP BY language
ORDER BY countries DESC;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) AS avg_lifeexpectancy
FROM country
GROUP BY continent
ORDER BY avg_lifeexpectancy DESC;


-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) AS avg_lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_lifeexpectancy DESC;


-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;


-- The average population of cities in each state in the USA ordered by state name
SELECT district, SUM(population), AVG(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;


-- SUBQUERIES

-- Find the names of cities in Europe with a gnp > 1,000,000
SELECT * FROM city;
SELECT * FROM country WHERE gnp > 1500000;

SELECT * FROM city
WHERE countrycode IN ('JPN', 'DEU', 'USA');

SELECT * FROM city
WHERE countrycode IN (SELECT code FROM country WHERE gnp > 1000000);

-- Find the names of cities under a given government leader
SELECT code FROM country WHERE headofstate = 'Elisabeth II';

SELECT * FROM city 
WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Elisabeth II');

-- Find the names of cities whose country they belong to has not declared independence yet
SELECT name FROM city WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);

-- Find the names of cities with a population > 1,500,000 in countries with a gnp > 1,000,000
-- and a population > 8,000,000
SELECT * FROM city
WHERE population > 1500000 AND countrycode IN (SELECT code FROM country WHERE gnp > 1000000 AND population > 8000000);

-- Cities in the country with the largest surface area
SELECT * FROM city
WHERE countrycode = (SELECT code FROM country ORDER BY surfacearea DESC LIMIT 1);



-- Additional samples
-- You may alias column and table names to be more descriptive
SELECT name AS city_name
FROM city AS cities;

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.
SELECT c.name AS city_name, co.name AS country_name
FROM city c, country co;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name, population
FROM city
WHERE countrycode = 'USA'
ORDER BY name ASC, population DESC;

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip
SELECT name, population
FROM city
LIMIT 10 OFFSET 20;


-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.
SELECT (name || ' in in the state of ' || district || '!')
FROM city
WHERE countrycode = 'USA';


-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. 
-- Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table
SELECT count(name)
FROM city;
-- Also counts the number of rows in the city table
SELECT count(population)
FROM city;

SELECT count(*)
FROM city;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT district, SUM(population), COUNT(population), AVG(population), MIN(population), MAX(population)
FROM city
GROUP BY district;
-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population) AS smallest_population, MAX(population) AS largest_population
FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
SELECT countrycode, MIN(population) AS smallest_population, MAX(population) AS largest_population
FROM city
GROUP BY countrycode;