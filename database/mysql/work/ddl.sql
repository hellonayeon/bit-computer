use mydb;

-- size: column 명으로 사용 불가능
CREATE TABLE tb_test01(
	col1 varchar(10),
	col2 varchar(20),
    col3 varchar(30)
);

CREATE TABLE tb_test02(
	id int,
    name varchar(30),
    height decimal(3, 1),
    birth date
);

-- table copy (테이블 복제): 데이터를 포함
DROP TABLE tb_test03;

CREATE TABLE tb_test03
AS
SELECT job_id AS jobid, max_salary AS maxsal
FROM jobs;

CREATE TABLE IF NOT EXISTS tb_test03
SELECT * FROM jobs;

SELECT * FROM tb_test03;

-- table copy (테이블 복제): 데이터 미포함 [MySQL]
CREATE TABLE IF NOT EXISTS tb_test04
LIKE jobs;

CREATE TABLE tb_test05
SELECT department_id AS "dnum", SUM(salary) AS "sum", AVG(salary) AS "avg"
FROM employees
GROUP BY department_id;

-- object: create, drop, alter
-- data: insert, delete, select, update
alter table tb_test04
rename
to tb_test99;

-- 컬럼 추가
alter table tb_test99
add
newcol1 varchar(30);

alter table tb_test99
add
(col2_new decimal(5,1), col3_new date);

DESC tb_test99;

-- 컬럼 데이터형 수정
alter table tb_test99
modify
newcol1 int;

-- 컬럼명 변경
alter table tb_test99
change
col2_new new_col2 varchar(20);

-- 컬럼 삭제
alter table tb_test99
drop
newcol1;

-- table copy (테이블 복제): 데이터 미포함 [Oracle, MySQL]
create table dept
as
select * 
from departments
where 1=2; -- 조건이 맞지 않는 조건을 포함


-- insert
insert into dept(department_id, department_name, manager_id, location_id) 
values(10, '기획부', 100, 101);

insert into dept(department_id, department_name) 
values(20, '관리부');

insert into dept(department_id) 
values(30);

insert into dept(manager_id, location_id, department_id, department_name)
values(110, 102, 30, '경리부');

delete from dept
where department_name = '경리부';

insert into dept
values(40, '개발부', 130, 103);

-- *** safe mode 설정 활성화 (default): delete, update
-- sql_safe_updates = 1 (default)
set sql_safe_updates = 0;


-- 삭제 
delete from dept
where department_name = '경리부';

-- 수정
update dept
set manager_id = 300
where department_id = 40;

-- 여러 컬럼 수정
update dept
set manager_id = 500, location_id = 333
where department_name = '개발부';

drop table dept;


/*
	무결성: constraint
		  column 을 지정하는 성질, column 설정
          
	primary key: 기본키 | NULL 불가능 | 중복 불가능 | ID,  주민번호
    unique key: 고유키 | NULL 가능 | 중복 불가능 | E-MAIL
    foreign key: 외래키 | JOIN (테이블과 테이블을 연결) | NULL 가능
				 외래키로 지정된 컬럼은 연결된 테이블에서 PK나 UK로 설정되어 있어야 한다 !
	check: 범위를 지정 | 값을 지정 | 지정된 값 외에 사용 불가능 | NULL 허용 | NULL 허용
    not null: NULL 불가능 | 중복 가능
*/

-- not null
create table tb_test06 (
	col1 varchar(10) not null,
    col2 varchar(20)
);

insert into tb_test06(col1, col2)
values('AAA', '111');

insert into tb_test06(col1)
values('BBB');

insert into tb_test06(col2)
values('222');

drop table if exists tb_test06;

-- primary key = unique + not null
create table tb_test06(
	pk_col varchar(10) primary key,
    col1 varchar(20),
    col2 varchar(30)
);

insert into tb_test06(pk_col, col1, col2)
values ('AAA', '111', 'aaa');

insert into tb_test06(pk_col)
values('BBB');

-- 대소문자가 구분이 아되므로 에러가 산출
insert into tb_test06(pk_col)
values('bbb');

-- ORACLE 에서는 허용하지 않으나, MySQL 에서는 허용 ('' (공백)도 NULL 로 처리)
insert into tb_test06(pk_col, col1, col2)
values('', '111', 'aaa');

drop table if exists tb_test06;

/* 기본키 설정 */
create table tb_test06(
	pk_col varchar(10),
    col1 varchar(20),
    col2 varchar(30),
    primary key(pk_col)
);

/* 이 경우에는 기본키 2개 불가능 */
/*
create table tb_test06(
	pk_col1 varchar(10) primary key,
    pk_col2 varchar(10) primary key,
    col1 varchar(20),
    col2 varchar(30),
    primary key(pk_col1, pk_col2)
);
*/
/* 이 방식으로는 기본키 2개 설정 가능하나, 잘 사용 X */
/*
create table tb_test06(
	pk_col1 varchar(10),
    pk_col2 varchar(10),
    col1 varchar(20),
    col2 varchar(30),
    primary key(pk_col1, pk_col2)
);
*/

create table tb_test06(
	pk_col varchar(10),
    col1 varchar(20),
    col2 varchar(30)
);

-- 기본키 추가
alter table tb_test06
add
primary key(pk_col);

-- 기본키 삭제
alter table tb_test06
drop
primary key; -- NOT NULL 은 남아 있음 !

-- unique: 고유키 | 중복 불가능 | NULL 가능 - NULL 은 가능하나, 같은 값은 불가능
create table tb_test07(
	uk_col varchar(10) unique,
    col1 varchar(20),
    col2 varchar(30)
);

-- V
insert into tb_test07(uk_col, col1, col2)
values('AAA', 'aaa', '111');

insert into tb_test07(uk_col, col1, col2)
values('', 'aaa', '111');

-- NULL은 가능 !
insert into tb_test07(col1, col2)
values('aaa', '111');

-- V 소문자지만 같은 값이므로 불가능
-- MySQL 은 대소문자 구분 X
insert into tb_test07(uk_col, col1, col2)
values('aaa', 'aaa', '111');

drop table if exists tb_test07;

create table tb_test07(
	pk_col varchar(10),
    col1 varchar(20),
    col2 varchar(30),
    unique (pk_col)
);

create table tb_test07(
	pk_col varchar(10),
    col1 varchar(20),
    col2 varchar(30)
);

alter table tb_test07
add
unique key (pk_col);


-- NULL 허용

-- parent table: departments
create table tb_dept(
	department_id varchar(10),
    department_name varchar(20),
    location_id decimal(3),
    primary key(department_id)
);

insert into tb_dept(department_id, department_name, location_id)
values('10', '기획부', 120);

insert into tb_dept(department_id, department_name, location_id)
values('20', '관리부', 150);

insert into tb_dept(department_id, department_name, location_id)
values('30', '개발부', 180);

create table tb_emp (
	empno int,
    ename varchar(30),
    department_id varchar(10),
    foreign key(department_id) references tb_dept(department_id),
    primary key(empno)
);

desc tb_emp;

insert into tb_emp(empno, ename, department_id)
values(100, '홍길동', '20');

insert into tb_emp(empno, ename, department_id)
values(101, '성춘향', '10');

insert into tb_emp(empno, ename, department_id)
values(102, '일지매', '30');

insert into tb_emp(empno, ename, department_id)
values(103, '정수동', '40');

insert into tb_emp(empno, ename)
values(104, '홍두꼐');

insert into tb_emp(empno, ename, department_id)
values(105, '임꺽정', null);

select empno, ename,
	e.department_id, d.department_id,
    d.department_name
from tb_emp e, tb_dept d
where e.department_id = d.department_id;


-- check
-- 지정된 값만 추가 가능 | NULL 허용 | 중복 허용
create table tb_check(
	col1 varchar(10),
    col2 int,
    constraint chk_01 check( col1 in('사과', '배', '바나나') ),
    constraint chk_02 check( col2 > 0 and col2 <= 10)
);

insert into tb_check(col1, col2)
values ('사과', 5);

insert into tb_check(col1, col2)
values ('귤', 11);