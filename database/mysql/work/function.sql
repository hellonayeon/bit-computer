/*

	select 구문
    
    delimiter $$
    begin
    
    create function 함수명(매개변수 자료형) returns 리턴 자료형
    
		select 쿼리 처리
    
    end $$
    delimiter ;

*/

-- 1418 error
set global log_bin_trust_function_creators = 1;

delimiter $$

create function func(p_val double) returns double
begin

	declare v_val double;
    
    set v_val = p_val;
    set v_val = v_val * 2;
    
    return v_val;

end $$

delimiter ;

select func(11);

set @num = func(22); -- 변수를 받아서 출력 가능
select @num;

-- 월급과 커미션을 합친 금액의 세금을 계산 15%
drop function if exists tax;

delimiter $$

create function tax(v_sal decimal(8,2), v_bonus decimal(2,0)) returns double

begin

	return (v_sal + (ifnull(v_bonus, 0)) * v_sal) * 0.15;
	
end
$$ delimiter ;

select tax(10, 10);

select first_name, salary + salary * ifnull(commission_pct, 0) as 실급여,
	salary * ifnull(commission_pct, 0) as 보너스,
    tax(salary, commission_pct) as 세금
from employees;

-- 사원번호를 입력하면, 업무명을 취득할 수 있는 함수

drop function if exists get_job_name;

delimiter $$

create function get_job_name(v_empno int) returns varchar(35)

begin

	declare v_job_name varchar(35);
    
    select job_title into v_job_name
    from employees e, jobs j
    where e.job_id = j.job_id
		  and employee_id = v_empno;
          
	return v_job_name;
    
end

$$ delimiter ;

set @jobname = get_job_name(103);
select @jobname;

select first_name, salary, get_job_name(employee_id)
from employees;