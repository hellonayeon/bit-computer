drop database if exists table_work;

create database table_work;

use table_work;

drop table if exists team_tb;
drop table if exists player_tb;
drop table if exists product_tb;
drop table if exists consumer_tb;
drop table if exists cart_tb;

--  1. 운동부 TABLE을 작성하라.
-- TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지
create table team_tb(
	team_id int,
    location varchar(30),
    team_name varchar(30),
    open_date date,
    tel_number varchar(20),
    homepage varchar(30),
    primary key(team_id)
);

-- PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디
create table player_tb (
	player_id int,
    player_name varchar(20),
    regist_date date,
    position varchar(20),
    height decimal(4, 1),
    team_id int,
    foreign key (team_id) references team_tb(team_id)
);

-- 3개의 TEAM을  등록합니다.
insert into team_tb (team_id, location, team_name, open_date, tel_number, homepage)
values (1001, 'Bucheon', 'A팀', '1990-09-25', '031-123-1234', 'http://bucheon.team');

insert into team_tb (team_id, location, team_name, open_date, tel_number, homepage)
values (1002, 'Goyang', 'B팀', '2000-05-13', '031-123-4567', 'http://goyang.team');

insert into team_tb (team_id, location, team_name, open_date, tel_number, homepage)
values (1003, 'Paju', 'C팀', '1989-02-21', '031-123-8910', 'http://paju.team');



-- 3 개의 TEAM에 선수를 3 ~ 9명을 등록(추가)합니다.
insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (101, '선수1', '1991-07-21', 'Batter', 175.4, 1001);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (101, '선수2', '2001-02-14', 'Pitcher', 169.3, 1001);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (101, '선수3', '2020-08-23', 'Pitcher', 173.2, 1001);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (201, '선수4', '2000-06-30', 'Pitcher', 178.1, 1002);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (202, '선수5', '2001-07-22', 'Batter', 177.4, 1002);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (203, '선수6', '2010-09-21', 'Batter', 180.4, 1002);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (301, '선수7', '1989-12-31', 'Pitcher', 169.1, 1003);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (302, '선수8', '1990-02-27', 'Batter', 171.5, 1003);

insert into player_tb (player_id, player_name, regist_date, position, height, team_id)
values (303, '선수9', '2021-09-29', 'Batter', 179.4, 1003);

-- 선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록 합니다. 
select player_name, team_name, tel_number, homepage
from team_tb t, player_tb p
where t.team_id = p.team_id;

-- 특정 선수 입력
select player_name, team_name, tel_number, homepage
from team_tb t, player_tb p
where t.team_id = p.team_id
	  and player_name = '선수5';

-- JOIN 해 보도록 합니다. 
select *
from team_tb t, player_tb p
where t.team_id = p.team_id;

-- 팀명으로 팀원들이 출력되도록 합니다. 
select team_name, player_id, player_name
from team_tb t, player_tb p
where t.team_id = p.team_id
	  and team_name = "A팀";
      
select team_name, player_id, player_name
from team_tb t, player_tb p
where t.team_id = p.team_id
	  and team_name = "B팀";

select team_name, player_id, player_name
from team_tb t, player_tb p
where t.team_id = p.team_id
	  and team_name = "C팀";
      
      
-- 2. 온라인 마켓 TABLE을 작성하라.

-- PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명
create table product_tb (
	product_id int,
    product_name varchar(50),
    price int,
    descript text,
    primary key (product_id)
);

-- CONSUMER(소비자) : 소비자 ID, 이름, 나이
create table consumer_tb(
	consumer_id int,
    consumer_name varchar(20),
    age int,
    primary key (consumer_id)
);

-- CART(장바구니) : 장바구니 번호, 소비자 ID, 구입일, 상품번호, 수량
create table cart_tb(
	cart_id int,
    consumer_id int not null,
    purchase_date date,
    product_id int not null,
    quantity int,
    primary key (cart_id),
    foreign key (consumer_id) references consumer_tb(consumer_id),
    foreign key (product_id) references product_tb(product_id)
);

-- 상품 테이블에 상품을 등록합니다(개수는 5가지이상).
insert into product_tb (product_id, product_name, price, descript)
values (101, '사과', 5000, '빨갛고 설탕같은 사과');

insert into product_tb (product_id, product_name, price, descript)
values (102, '바나나', 10000, '원숭이가 좋아하는 바나나');

insert into product_tb (product_id, product_name, price, descript)
values (201, '칫솔', 20000, '이빨이 잘 닦이는 칫솔');

insert into product_tb (product_id, product_name, price, descript)
values (301, '텀블러', 15000, '보냉이 잘되는 텀플러');

insert into product_tb (product_id, product_name, price, descript)
values (401, '아이스크림', 500, '초특가 할인 아이스크림');

-- 소비자를 등록합니다.
-- (10명이상)
insert into consumer_tb (consumer_id, consumer_name, age)
values (1001, '김길동', 10);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1002, '이길동', 11);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1003, '박길동', 12);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1004, '강길동', 13);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1005, '노길동', 14);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1006, '황길동', 15);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1007, '안길동', 16);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1008, '신길동', 17);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1009, '장길동', 18);

insert into consumer_tb (consumer_id, consumer_name, age)
values (1010, '최길동', 19);

-- 소비자가 쇼핑한 상품을 추가합니다.
insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2001, 1001, '2022-06-01', 101, 3);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2002, 1001, '2022-06-02', 102, 5);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2003, 1001, '2022-06-05', 201, 10);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2004, 1002, '2022-05-23', 301, 1);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2005, 1002, '2022-05-24', 401, 20);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2006, 1003, '2022-05-01', 101, 10);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2007, 1003, '2022-05-10', 101, 5);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2008, 1009, '2022-05-25', 201, 5);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2009, 1009, '2022-05-30', 301, 10);

insert into cart_tb (cart_id, consumer_id, purchase_date, product_id, quantity)
values (2010, 1009, '2022-06-01', 401, 100);

-- 쇼핑한 상품을 출력합니다.
select cart.cart_id, cons.consumer_id, consumer_name, product_name, quantity
from consumer_tb cons, product_tb prod, cart_tb cart
where cons.consumer_id = cart.consumer_id
	  and prod.product_id = cart.product_id
order by consumer_id asc;
      

-- 소비자와 기간을 입력하면, 그 기간동안 구입한 물품이 출력됩니다.
select cons.consumer_id, consumer_name, product_name, quantity
from consumer_tb cons, product_tb prod, cart_tb cart
where cons.consumer_id = cart.consumer_id
	  and prod.product_id = cart.product_id
	  and consumer_name = '장길동'
      and cart.purchase_date >= '2022-05-01' and cart.purchase_date <= '2022-05-30';

select cons.consumer_id, consumer_name, product_name, quantity
from consumer_tb cons, product_tb prod, cart_tb cart
where cons.consumer_id = cart.consumer_id
	  and prod.product_id = cart.product_id
	  and consumer_name = '장길동'
      and cart.purchase_date >= '2022-06-01' and cart.purchase_date <= '2022-06-30';
