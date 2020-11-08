use employees;

#Activity1

create database sdet4_sameer;

create table salesman(
	salesman_id int primary key,
    name varchar(32),
    city varchar(32),
    commission int
);
    
describe salesman;

#Activity2

insert into salesman values(5001, 'James Hoog','New York',15);
insert into salesman values(5002, 'Nail Knite','Paris',13);
insert into salesman values(5005, 'Pit Alex','London',11);
insert into salesman values(5006, 'McLyon','Paris',14);
insert into salesman values(5007, 'Paul Adam','Rome',13);
insert into salesman values(5003, 'Lauson Hen','San Jose',12);

select * from salesman;

#Activity3

select salesman_id, city from salesman;

select * from salesman where city = 'Paris';

select salesman_id, city from salesman where name ='Paul Adam';

#Activity4

alter table salesman add grade int;

update salesman set grade=100;

select * from salesman;

#Activity5

update salesman set grade=200 where city='Rome';

update salesman set grade=300 where name='James Hoog';

update salesman set name='Pierre' where name='McLyon';

#Activity6

create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);
    
insert into orders values
(70001, 150.5, '2012-10-05', 3005, 5002), (70009, 270.65, '2012-09-10', 3001, 5005),
(70002, 65.26, '2012-10-05', 3002, 5001), (70004, 110.5, '2012-08-17', 3009, 5003),
(70007, 948.5, '2012-09-10', 3005, 5002), (70005, 2400.6, '2012-07-27', 3007, 5001),
(70008, 5760, '2012-08-15', 3002, 5001), (70010, 1983.43, '2012-10-10', 3004, 5006),
(70003, 2480.4, '2012-10-10', 3009, 5003), (70012, 250.45, '2012-06-27', 3008, 5002),
(70011, 75.29, '2012-08-17', 3003, 5007), (70013, 3045.6, '2012-04-25', 3002, 5001);

select distinct salesman_id from orders;

select order_no, order_date from orders order by order_date;

select order_no, purchase_amount from orders order by purchase_amount desc;

select * from orders where purchase_amount<500;

select * from orders where purchase_amount between 1000 and 2000;

#Activity7

select sum(purchase_amount) as 'TOTAL' from orders;

select avg(purchase_amount) as 'AVERAGE' from orders;

select max(purchase_amount) as 'MAXIMUM' from orders;

select min(purchase_amount) as 'MINIMUM' from orders;

select count(distinct salesman_id) as 'COUNT' from orders;

#Activity8

select customer_id, max(purchase_amount) as 'MAXIMUM PURCHASE' from orders group by customer_id;

select salesman_id, order_date, max(purchase_amount) as 'MAXIMUM PURCHASE' from orders 
where order_date='2012-08-17' group by salesman_id;

select customer_id, order_date, max(purchase_amount) as 'MAXIMUM PURCHASE' from orders
group by customer_id, order_date
having max(purchase_amount) in (2030,3450,5760,6000);

#Activity9

create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);
    
insert into customers values 
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

select a.customer_name as 'CUSTOMER NAME', a.city, b.name as 'SALESMAN', b.commission 
from customers a inner join salesman b on a.salesman_id=b.salesman_id;

select a.customer_name, a.city, a.grade, b.name as 'salesman', b.city from customers a
left outer join salesman b on a.salesman_id = b.salesman_id where a.grade<300 order by customer_id;

select a.customer_name as 'customer name', a.city, b.name as 'salesman', b.commission from
customers a inner join salesman b on a.salesman_id=b.salesman_id where b.commission>12;

select a.order_no, a.order_date, a.purchase_amount,
b.customer_name as 'customer name', b.grade,
c.name as 'salesman', c.commission from orders a
inner join customers b on a.customer_id=b.customer_id
inner join salesman c on a.salesman_id=c.salesman_id;

#Activity10

select * from orders 
where salesman_id=(select distinct salesman_id from orders where customer_id=3007);

select * from orders
where salesman_id=(select salesman_id from salesman where city='New York');

select grade,count(*) from customers group by grade
having grade>(select avg(grade) from customers where city='New York');

select order_no, purchase_amount, order_date, salesman_id from orders
where salesman_id in(select salesman_id from salesman
where commission=(select max(commission) from salesman));

#Activity11

select customer_id, customer_name from customers a
where 1<(select count(*) from orders b where a.customer_id=b.customer_id)
union select salesman_id, name from salesman a
where 1<(select count(*) from orders b where a.salesman_id=b.salesman_id)
order by customer_name;

select a.salesman_id, name, order_no, 'highest on' as high_low, order_date from salesman a, orders b
where a.salesman_id=b.salesman_id
and b.purchase_amount=(select max(purchase_amount) from orders c
where c.order_date=b.order_date)
union select a.salesman_id, name, order_no, 'lowest on', order_date from salesman a, orders b
where a.salesman_id=b.salesman_id
and b.purchase_amount=(select min(purchase_amount) from orders c
where c.order_date=b.order_date);