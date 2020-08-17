-- The name and population of all cities in the USA with a population of greater than 1 million people
SELECT name, population 
FROM city
WHERE population > 1000000 AND countrycode = 'USA';


-- The name and population of all cities in China with a population of greater than 1 million people
SELECT name, population 
FROM city
WHERE population > 1000000 AND countrycode = 'CHN';

-- The name and region of all countries in North or South America
  
-- The name, continent, and head of state of all countries whose form of government is a monarchy

-- The name, country code, and population of all cities with a population less than one thousand people

-- The name and region of all countries in North or South America except for countries in the Caribbean

-- The name, population, and GNP of all countries with a GNP greater than $1 trillion dollars and a population of less than 1 billion people

-- The name and population of all cities in Texas that have a population of greater than 1 million people

-- The name and average life expectancy of all countries in southern regions

-- The name and average life expectancy of all countries in southern regions for which an average life expectancy 
-- has been provided (i.e. not equal to null)
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL AND region ILIKE '%south%';


-- The name, continent, GNP, and average life expectancy of all  in Africa or Asia that have an average 
-- life expectancy of at least 70 years and a GNP between $1 billion (1000) and $100 billion dollars  (100000)
SELECT * 
FROM country
WHERE continent IN ('Africa', 'Asia') 
AND lifeexpectancy >= 70
AND gnp BETWEEN 1000 AND 100000;