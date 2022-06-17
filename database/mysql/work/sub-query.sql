/*
	Sub Query
    
    Query 안의 Query
    
    SELECT 단일 row, 단일 Column
    FROM 다중 row, 다중 column
    WHERE 다중 row,다중 column

*/

-- SELECT

SELECT employee_id, last_name,
	(SELECT last_name
	FROM employees
    WHERE employee_id = 100)
FROM employees;

SELECT employee_id, first_name,
	(SELECT last_name/* salary*/ -- 다중 컬럼 사용 불가, 단일 행, 단일 컬럼 만 사용 가능
	FROM employees
    WHERE employee_id = 100)
FROM employees;

SELECT first_name, first_name,
	(select sum(salary) from employees),
    (select avg(salary) from employees)
FROM employees;


-- FROM

SELECT employee_id, first_name, salary
FROM ( SELECT department_id, employee_id, first_name, salary 
		FROM employees 
        WHERE department_id = 100) a
WHERE salary > 8000;

SELECT empno, ename, sal
FROM
	(SELECT employee_id as empno, first_name as ename, salary as sal
	FROM employees
	WHERE department_id = 50) a
WHERE sal >= 6000;


-- 업무별로 급여의 합계, 인원 수, 사원명, 월급
/*
SELECT e.employee_id, e.first_name, a.job_id, a.급여합계, a.인원수
FROM employees e, (SELECT job_id, sum(salary) as 급여합계, COUNT(*) as 인원수
					FROM employees
					GROUP BY job_id) a;

SELECT e.employee_id, e.first_name, a.job_id, a.급여합계, a.인원수
FROM employees e, (SELECT job_id, sum(salary) as 급여합계, COUNT(*) as 인원수
					FROM employees
					GROUP BY job_id) a;
                    
SELECT a.employee_id, a.first_name, a.job_id, a.급여합계, a.인원수
FROM (SELECT employee_id, first_name, job_id, sum(salary) as 급여합계, COUNT(*) as 인원수
					FROM employees
					GROUP BY job_id) a;
*/

-- WHERE
-- 평균 급여보다 많이 받는 사원
SELECT employee_id, first_name, salary
from employees
where salary > (SELECT AVG(salary) FROM employees);

-- 부서 번호가 90인 사원의 업무명
SELECT job_id, first_name, department_id
FROM employees
WHERE job_id in (SELECT job_id
					FROM employees
					WHERE department_id = 90);

-- 부서 별로 가장 급여를 적게 받는 사원의 급여와 같은 급여를 받는 사원

SELECT employee_id, first_name, salary
FROM employees
WHERE salary IN (SELECT MIN(salary)
				FROM employees
				GROUP BY department_id);
                
-- 부서별로 가장 적은 급여를 받는 사원
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MIN(salary)
									FROM employees
									GROUP BY department_id)
ORDER BY department_id;


-- 부서별로 가장 많은 급여를 받는 사원
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MAX(salary)
									FROM employees
									GROUP BY department_id)
ORDER BY department_id;

-- 특수 쿼리
-- substr('문자열', start index) -- DB는 1번지부터 시작
-- substr('hello world', 1) -- hello world
-- substr('문자열', start index, char cnt)
-- substr('hello world', 1, 5) -- hello
-- case == ㄴswitch
SELECT employee_id, first_name, phone_number,
		case substr(phone_number, 1, 3)
			WHEN '515' THEN '서울'
            WHEN '590' THEN '부산'
            WHEN '650' THEN '광주'
			ELSE '기타'
		END AS 지역
FROM employees;


-- over() 함수
-- GROUP BY를 보강하기 위해서 나온 함수
-- SELECT 절 에서만 사용
/*
SELECT department_id, count(*) over(), first_name
FROM employees
GROUP BY department_id;
*/

-- PARTITION BY == SELECT 절 안에 GROUP BY
SELECT first_name, salary, department_id,
		count(*) over(partition by department_id)
FROM employees;


-- 순위함수
/*
	RANK() 1 2 3 3 5 6
    DENSE_RANK() 1 2 3 3 4 5
    ROW_NUMBER() 1 2 3 4 5
    ROWNUM -> @rownum:=@rownum+1
*/

SELECT employee_id, first_name, salary,
	RANK()OVER(ORDER BY salary DESC) as "RANK",
	DENSE_RANK()OVER(ORDER BY salary DESC) as "DENSE_RANK",
    ROW_NUMBER()OVER(ORDER BY salary DESC) as "ROW_NUMBER"
FROM employees;

SELECT @rownum:=@rownum+1, employee_id, first_name
FROM employees
WHERE (@rownum:=0)=0
	AND @rownum < 10;
    
SELECT @rownum:=@rownum+1, employee_id, first_name
FROM employees, (SELECT @rownum:=0) rnum
WHERE @rownum < 10;
    
SELECT @rownum:=@rownum+1, employee_id, first_name
FROM employees, (SELECT @rownum:=0) rnum
WHERE @rownum > 10 AND @rownum <= 20;


(SELECT @rownum:=@rownum+1, employee_id, first_name, salary
FROM employees, (SELECT @rownum:=0) rnum
ORDER BY salary DESC);

-- ** 중요
-- RANK 는 SELECT 절에만 사용 가능
SELECT rnum, employee_id, first_name, salary
FROM
	(SELECT @rownum:=@rownum+1 as rnum, employee_id, first_name, salary
	FROM employees, (SELECT @rownum:=0) r
	ORDER BY salary DESC) a
-- WHERE rnum > 10 AND rnum <= 20;
WHERE rnum BETWEEN 11 AND 20;