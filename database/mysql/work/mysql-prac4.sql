-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
-- MySQL
SELECT first_name, d.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d
				 ON e.department_id = d.department_id;

-- 문제2) 30번 부서의 사원들의 이름,직업,부서명을 출력하라
-- ansi
SELECT first_name, job_title, department_name
FROM (employees e LEFT OUTER JOIN departments d
				  ON e.department_id = d.department_id) 
                  LEFT OUTER JOIN jobs j
				  ON e.job_id = j.job_id;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호,부서명을 출력하라
SELECT first_name, job_title, d.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d
				 ON e.department_id = d.department_id
				 LEFT OUTER JOIN jobs j
				 ON e.job_id = j.job_id
WHERE e.commission_pct IS NOT NULL;


-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업,부서번호,부서명을 출력하라
SELECT first_name, job_title, d.department_id, department_name
FROM employees e LEFT OUTER JOIN departments d
				 ON e.department_id = d.department_id
                 LEFT OUTER JOIN jobs j
                 ON e.job_id = j.job_id
                 LEFT OUTER JOIN locations l
                 ON d.location_id = l.location_id
WHERE l.location_id = 2500;

-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
SELECT first_name, department_name
FROM employees e LEFT OUTER JOIN departments d
			     ON e.department_id = d.department_id
WHERE first_name LIKE '%A%';

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
SELECT emp.first_name, mgr.first_name
FROM employees emp LEFT OUTER JOIN employees mgr
				   ON emp.manager_id = mgr.employee_id;

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 6000 이상인 사원을 출력하라
SELECT first_name, department_name, salary
FROM employees e LEFT OUTER JOIN departments d
				 ON e.department_id = d.department_id
WHERE salary >= 6000;

-- 문제8) first_name 이 TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라

SELECT first_name, hire_date
FROM employees
WHERE hire_date > (SELECT hire_date
					FROM employees
					WHERE first_name = "TJ");

SELECT tj.first_name, tj.hire_date, e.hire_date, e.first_name
FROM employees tj, employees e
WHERE tj.first_name = 'TJ'
	AND tj.hire_date < e.hire_date;


-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
SELECT first_name, department_name
FROM employees e LEFT OUTER JOIN departments d
				 ON e.department_id = d.department_id
WHERE salary BETWEEN 3000 AND 5000;


-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
SELECT first_name, hire_date
FROM employees e INNER JOIN departments d
				 ON e.department_id = d.department_id
WHERE department_name = "ACCOUNTING";


-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지를 출력하라
SELECT first_name, salary, street_address
FROM employees e LEFT OUTER JOIN departments d
				 ON e.department_id = d.department_id
                 LEFT OUTER JOIN locations l
                 ON d.location_id = l.location_id
                 
WHERE salary <= 3000;