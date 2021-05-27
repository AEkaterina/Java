use java_souvenir;

drop table souvenir;
drop table manufacturer;

create table manufacturer
(
	requisites int primary key unique,
	name varchar(30),
    country varchar(30)
);

create table souvenir
(
	id int primary key auto_increment, 
	name varchar(30) not null,
    requisites int not null,
    date int not null,
    price int check (price > 0),
    foreign key (requisites) references manufacturer (requisites) 
);

insert manufacturer (requisites, name, country)
values (20, 'EasyGifts', 'Poland'),
	   (29, 'MidOcean', 'France'),
       (37, 'HappyGifts', 'Russia'),
       (49, 'Sols', 'France'),
       (23, 'FruitOfTheLoom', 'Germany'),
       (65, 'Project111', 'Russia');
       
insert souvenir (name, requisites, date, price)
values ('notebook', 20, 2020, 22),
	   ('pen', 20, 2021, 15),
       ('lunchbox', 29, 2021, 31),
       ('lamp', 29, 2020, 49),
       ('pen', 37, 2020, 19),
       ('hoodie', 49, 2021, 55),
       ('sweatshirt', 49, 2020, 50),
       ('t-shirt', 49, 2020, 30),
       ('jacket', 23, 2021, 60),
       ('hoodie', 23, 2021, 45),
       ('notebook', 65, 2020, 25),
       ('calendar', 65, 2021, 10);
       
select * from manufacturer;
select * from souvenir;

select souvenir.id as 'ID',
	   souvenir.name as 'Name',
       souvenir.price as 'Price',
       manufacturer.country as 'Country'
from manufacturer inner join souvenir
on manufacturer.requisites = souvenir.requisites
where manufacturer.name = 'FruitOfTheLoom';

select souvenir.id as 'ID', 
	   souvenir.name as 'Name', 
       souvenir.price as 'Price', 
       manufacturer.name as 'Manufacturer'
from manufacturer inner join souvenir
on manufacturer.requisites = souvenir.requisites
where manufacturer.country = 'France';


select manufacturer.name as 'Manufacturer',
	   manufacturer.requisites as 'Requisites',
       manufacturer.country as 'Country',
       souvenir.name as 'Souvenir',
       souvenir.price as 'Price'
from manufacturer inner join souvenir
on manufacturer.requisites = souvenir.requisites
where souvenir.price < 35;

select manufacturer.name as 'Manufacturer',
	   manufacturer.requisites as 'Requisites',
       manufacturer.country as 'Country'
from manufacturer inner join souvenir
on manufacturer.requisites = souvenir.requisites
where souvenir.date = 2020 and souvenir.name = 'pen';
