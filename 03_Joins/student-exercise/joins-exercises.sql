-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT title
from actor
join film_actor ON actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'NICK' and actor.last_name = 'STALLONE';


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)

SELECT title
from actor
join film_actor ON actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'RITA' and actor.last_name = 'REYNOLDS';


-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

SELECT title
from actor
join film_actor ON actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'JUDY' and actor.last_name = 'DEAN' or actor.first_name = 'RIVER'  and actor.last_name = 'DEAN';



-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT title
from category
JOIN film_category on film_category.category_id = category.category_id
join film on film.film_id = film_category.film_id
where category.name = 'Documentary';

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT title
from category
JOIN film_category on film_category.category_id = category.category_id
join film on film.film_id = film_category.film_id
where category.name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT title
from category
JOIN film_category on film_category.category_id = category.category_id
join film on film.film_id = film_category.film_id
where category.name = 'Family' and film.rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)film.rating film.length family films
SELECT title
FROM category
JOIN film_category on film_category.category_id = category.category_id
join film on film.film_id = film_category.film_id
where category.name = 'Family' and film.rating =  'G' and film.length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
 SELECT title
from actor
join film_actor ON actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'MATTHEW' and actor.last_name = 'LEIGH' and film.rating = 'G';



-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT title
from category
join film_category ON film_category.category_id = category.category_id
join film on film.film_id = film_category.film_id
where category.name = 'Sci-Fi' and film.release_year = '2006';


-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

select title
from actor 
join film_actor on film_actor.actor_id = actor.actor_id
join film on film.film_id = film_actor.film_id
join film_category on film_category.film_id = film.film_id
join category on film_category.category_id = category.category_id
where actor.first_name = 'NICK' and actor.last_name = 'STALLONE'and category.name = 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

select address.address, country.country, city.city, address.district
from store
join address on address.address_id = store.address_id
join city on address.city_id = city.city_id
join country on city.country_id = country.country_id 
group by address.address, country.country, city.city, address.district;



-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
select store.store_id, address.address, staff.first_name || ','|| staff.last_name AS manager
from store
join staff on store.store_id = staff.store_id
join address on store.address_id = address.address_id
join city on address.city_id = city.city_id
join country on country.country_id = city.country_id;



-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
select *
from rental;

select customer.first_name, customer.last_name, count(rental.customer_id)
from rental
join customer on rental.customer_id = customer.customer_id
join payment on rental.customer_id = payment.customer_id
group by customer.first_name, customer.last_name
order by count desc
limit 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
select customer.first_name , customer.last_name, sum(payment.amount)
from payment
join customer on customer.customer_id = payment.customer_id
group by customer.first_name, customer.last_name
order by sum desc
limit 10;


-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
 select store.store_id , address.address, count(*), sum(payment.amount), avg(payment.amount)
 from rental
 join payment on payment.rental_id = rental.rental_id
 join inventory on rental.inventory_id = inventory.inventory_id
 join store on store.store_id = inventory.store_id
 join address on store.address_id = address.address_id
 group by store.store_id, address.address;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
select *
from film
join inventory on inventory.film_id = film.film_id
join rental on rental.inventory_id = inventory.inventory_id
limit 10;
--
-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)



-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)


-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)