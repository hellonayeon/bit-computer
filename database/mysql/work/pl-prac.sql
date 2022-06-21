-- 1. 사원번호를 입력 받으면 다음과 같이 출력되는 PROCEDURE를 작성하라.

-- Purchasing 부서의 Alexander사원입니다

drop procedure if exists get_dept_emp;

delimiter $$
create procedure get_dept_emp(in v_empno int)
begin
    declare v_dept_name varchar(30);
    declare v_emp_fname varchar(20);
    
    select department_name, first_name
		into v_dept_name, v_emp_fname
    from departments d, employees e
    where d.department_id = e.department_id
		 and employee_id = v_empno;
    
    select concat(v_dept_name, ' 부서의 ', v_emp_fname, '사원입니다');
end
$$ delimiter ;

-- 1번 문제 출력
call get_dept_emp(148);



-- 2. 사원번호를 입력받고, 소속부서의 최고, 최저연봉 차액을 파라미터로 출력하는 PROCEDURE를 작성하라.

drop procedure if exists diff_max_min_salary;

delimiter $$
create procedure diff_max_min_salary(in v_empno int)
begin
	declare v_dept_name varchar(35);
    declare v_max_sal decimal(8,2);
    declare v_min_sal decimal(8,2);
    declare v_diff decimal(8,2);
    
    select department_name, max(salary), min(salary)
		into v_dept_name, v_max_sal, v_min_sal
	from employees e, departments d
    where e.department_id = d.department_id
		and d.department_id = (select department_id
							   from employees
							   where employee_id = v_empno)
	group by d.department_id;
    
    set v_max_sal = v_max_sal*12;
    set v_min_sal = v_min_sal*12;
    set v_diff = v_max_sal - v_min_sal;
    
    select v_dept_name as '소속 부서', v_diff as '최저 최고 연봉 차액', v_max_sal as '최고 연봉', v_min_sal as '최저 연봉';
    
end
$$ delimiter ;

-- 2번 문제 출력
call diff_max_min_salary(100);



-- 3. 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수를 정의하시오.

drop function if exists get_emp_cnt;

delimiter $$
create function get_emp_cnt(v_deptno int) returns int
begin
	
    declare v_emp_cnt int;
    
    select count(*)
		into v_emp_cnt
    from departments
    where department_id = v_deptno;
    
    return v_emp_cnt;
end
$$ delimiter ;

-- 3번 문제 출력
set @deptno = 50;

select department_name as '부서명', get_emp_cnt(@deptno) as '사원수'
from departments
where department_id = @deptno;

select first_name
from employees
where department_id = @deptno;

-- 4. employees 테이블의 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수를 정의하시오.

drop function if exists get_mgr_name;
drop table if exists emp_mgr_tb;

create table emp_mgr_tb(
	emp_name varchar(20),
    mgr_name varchar(20)
);

delimiter $$
create function get_mgr_name(v_empno int) returns varchar(20)
begin
    declare v_mgr_name varchar(20);
    
    select m.first_name
		into v_mgr_name
    from employees e, employees m
    where e.manager_id = m.employee_id
		and e.employee_id = v_empno;
    
    return v_mgr_name;
end
$$ delimiter ;

-- 4번 문제 출력
set @empno = 150;
select concat('사원 번호 ', @empno, '의 매니저 이름 = ', get_mgr_name(@empno)); 


-- 5. employees 테이블을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수를 정의하시오.

-- 18000 ~ 24000 A, 
-- 12000 ~ 18000 미만 B, 
-- 8000 ~ 12000 미만 C, 
-- 3000 ~ 8000 미만 D, 
-- 그 외에는 F,

drop function if exists get_sal_grade;

delimiter $$
create function get_sal_grade(empno int) returns char
begin
	
    declare v_sal decimal(8,2);
    declare v_grade char;
    
    select salary
		into v_sal
    from employees
    where employee_id = empno;
    
    if v_sal >= 18000 and v_sal <= 24000 then
		set v_grade = 'A';
	elseif v_sal >= 12000 and v_sal < 18000 then
		set v_grade = 'B';
	elseif v_sal >= 8000 and v_sal < 12000 then
		set v_grade = 'C';
	elseif v_sal >= 3000 and v_sal < 8000 then
		set v_grade = 'D';
	end if;
    
    return v_grade;
end
$$ delimiter ;

set @empno = 101;
select concat('사원 번호 ', @empno, '의 급여 등급 = ', get_sal_grade(@empno));




