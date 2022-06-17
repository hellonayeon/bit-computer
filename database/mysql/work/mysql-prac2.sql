-- 문제1) EMPLOYEES 테이블에서 급여가 6000이상인 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.

SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary >= 6000;


-- 문제2) EMPLOYEES 테이블에서 담당 업무가 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라.

SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE job_id = 'ST_MAN';


-- 문제3) EMPLOYEES 테이블에서 입사일자가 1999년 1월 1일 이후에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.

SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date > '1999-01-01';

SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date > DATE('1999-01-01');


-- 1999 년도에 입사한 사람

SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date LIKE '1999%';


-- 문제4) EMPLOYEES 테이블에서 급여가 3000에서 5000사이의 사원의 성명, 담당업무, 급여, 부서번호를 출력하라. 

SELECT first_name, job_id, salary, department_id
FROM employees
WHERE salary >= 3000 AND salary <= 5000;

SELECT *
FROM employees
WHERE salary BETWEEN 3000 AND 5000;


-- 문제5) EMPLOYEES 테이블에서 사원번호가 145,152,203인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하라

SELECT employee_id, first_name, job_id, salary, hire_date
FROM employees
WHERE employee_id = 145 OR employee_id = 152 OR employee_id = 203;

SELECT employee_id, first_name, job_id, salary, hire_date
FROM employees
WHERE employee_id IN(145, 152, 203);


-- 문제6) EMPLOYEES 테이블에서 입사일자가 2000년도에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.

SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date LIKE '2000%';


-- 문제7) EMPLOYEES 테이블에서 보너스가 NULL인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 보너스, 부서번호를 출력하라.

SELECT employee_id, first_name, job_id, hire_date, commission_pct, department_id
FROM employees
WHERE commission_pct IS NULL;


-- 문제8) EMPLOYEES 테이블에서 급여가 7000이상이고 JOB이 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라 
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 7000 AND job_id = 'ST_MAN';


-- 문제9) EMPLOYEES 테이블에서 급여가 10000이상이거나 JOB이 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라 

SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 10000 OR job_id = 'ST_MAN';


-- 문제10) EMPLOYEES 테이블에서 JOB_ID가 ST_MAN, SA_MAN, SA_REP가 아닌 사원의 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라

SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE job_id NOT IN('ST_MAN', 'SA_MAN', 'SA_REP'); 


-- 문제11) 업무가 PRESIDENT이고 급여가 12000이상이거나 업무가 SA_MAN인 사원의 사원번호, 이름, 업무, 급여를 출력하라.

SELECT *
FROM employees
WHERE job_id = 'AD_PRES' AND salary > 120000 OR job_id = 'SA_MAN';



-- 문제12) 업무가 PRESIDENT또는 SALESMAN이고 급여가 12000이상의 사원의 사원번호, 이름, 업무, 급여를 출력하라.

SELECT *
FROM employees
WHERE job_id = 'AD_PRES' OR job_id = 'SA_MAN' AND salary >= 120000;