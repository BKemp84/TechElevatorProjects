-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

SELECT *
FROM actor;

INSERT INTO actor
VALUES ('201', 'HAMPTON', 'AVENUE');

INSERT INTO actor
VALUES ('202', 'LISA', 'BYWAY');

--UPDATE countrylanguage
--SET language = 'Krypto-babble'
--WHERE language = 'Kryptonese';

--INSERT into actor-id
---- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
select *
from film;
--where title = 'Euclidean PI';

insert into film
values ('1001', 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in
ancient Greece', '2008', '1', null, '3', '4.99','199', '26.99', 'G');


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.


insert into film_actor
 values ('201', '1001');
  

insert into film_actor
values ('202', '1001');



-- 4. Add Mathmagical to the category table.
select *
from category;

insert into category
values ('17', 'Mathmagical');


-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
select *
from film_category ;

select *
from film
where title = 'Euclidean PI';


insert into film_category
values ('1001', '17');

insert into film_category
values ('274', '17');

insert into film_category
values ('494', '17');

insert into film_category
values ('714', '17');

insert into film_category
values ('996', '17');



-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

select category_id from category where category = '17';

UPDATE film
SET rating = (select category_id from category where category = '17')
WHERE rating = 'G';

-- 7. Add a copy of "Euclidean PI" to all the stores.
select * 
from inventory
where film_id = '1001';

insert into inventory
values ('10000', '1001','1');  

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE> 
select *
from film;

delete
from film
where title = 'Euclidean PI';

-- did not succeed, table film violates foreign key constraint on table film_actor



-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
DELETE
from category
where category_id = '17';
-- <YOUR ANSWER HERE>
-- Did not succeed, foreign key constraint, (id) value still referenced in fil_category table.

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
transaction 
select *
from film
rollback;

-- <YOUR ANSWER HERE>


-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>




-- brian said don't do it
-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
