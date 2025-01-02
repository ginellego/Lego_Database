/*
**Course:	 COMP3380
**Instructor:    Patrick Dubois
**Project Part:		 2
**Name:		 Ginelle Temull, Braydon Schick
**
**Description: 	  
*/


use cs3380; 

drop table if EXISTS orders; 
drop table if EXISTS orderLineItems; 
drop table if EXISTS viewed; 
drop table if EXISTS people; 
drop table if EXISTS products; 
drop table if EXISTS provinces; 



create table provinces (
    provinceID varchar(3) primary key,
    name text not null,
    taxRate REAL not null
);

create table products (
    productID integer primary key identity(1,1),
    price numeric,
    prodName text
);

create table people (
    personID integer primary key identity(1,1),
    firstname text not null,
    lastname text not null,
    provinceID varchar(3) references provinces
);

create table viewed (
    personID integer references people(personID),
    productID integer references products(productID),
    -- just to show both ways
    -- foreign key (productID) references products(productID),
    primary key (personID, productID)
);

create table orders(
    orderID integer primary key,
    personID integer references people
    -- could imagine a date here, shipping info, etc.
);

create table orderLineItems(
    lineItemID integer primary key,
    orderID integer references orders on delete cascade,
    productID integer references products(productID)
);

-- as of 2020
-- data from https://www.retailcouncil.org/resources/quick-facts/sales-tax-rates-by-province/
insert into provinces values ('MB', ' Manitoba', 0.05);
insert into provinces values ('AB', 'Alberta', 0.00);
insert into provinces values ('SK', 'Saskatchewan', 0.06);
insert into provinces values ('BC', 'British Columbia', 0.07);
insert into provinces values ('ON', 'Ontario', 0.08); 