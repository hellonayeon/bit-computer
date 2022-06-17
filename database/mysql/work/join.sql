/*

	조인 (Join)
    두 개 이상의 테이블을 연결해서 데이터를 검색하는 방법
    보통 두 개 이상의 행(row) 들의 공통된 기본키, 외래키를 사용해서 조인
    
    목적: 현재 테이블에서 상대 테이블의 정보(column)를 산출하기 위한 처리
    
	기본키: 테이블에서 중복되지 않는 컬럼
    외래키: 다른 테이블에서 기본키로 설정
    
    조인 종류
    Inner Join ***
    Full Outer Join
    Cross Join
    Outer Join
		Left Outer Join ***
		Right Outer Join ***
	Self Join ( Inner Join )departments
   
    */
    
-- Inner Join
-- ansi SQL
SELECT employee_id, first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e INNER JOIN departments d -- 테이블의 alias 는 'as' 사용 X
		ON e.department_id = d.department_id;
	
    -- MySQL
    SELECT *
    FROM employees e, departments d
    WHERE e.department_id = d.department_id;
    
    SELECT e.employee_id, e.first_name,
		e.job_id, j.job_id,
		j.job_title
	FROM employees e, jobs j
    WHERE e.job_id = j.job_id
		AND e.job_id = 'IT_PROG';
	
    -- 3개 테이블 조인
	SELECT employee_id, first_name, e.department_id, department_name, job_title
    FROM employees e, departments d, jobs j
    WHERE e.department_id = d.department_id
		AND e.job_id = j.job_id;
	
    -- Cross Join
    -- ansi
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
	FROM employees e CROSS JOIN departments d;
    
    -- MySQL
    SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e, departments d;
    
    -- Left Outer Join
    -- ansi
    SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e LEFT OUTER JOIN departments d
		ON e.department_id = d.department_id;
        
        
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e RIGHT OUTER JOIN departments d
		ON e.department_id = d.department_id;
        
	-- Full Outer Join
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e LEFT OUTER JOIN departments d
		ON e.department_id = d.department_id
	UNION -- Fuul Outer Join
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e RIGHT OUTER JOIN departments d
		ON e.department_id = d.department_id;
        
	
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e LEFT OUTER JOIN departments d
		ON e.department_id = d.department_id
	WHERE e.department_id IS NULL;
    
    SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e RIGHT OUTER JOIN departments d
		ON e.department_id = d.department_id
	WHERE e.department_id IS NULL;
    
    
    -- Full Outer Join
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e LEFT OUTER JOIN departments d
		ON e.department_id = d.department_id
        WHERE e.department_id IS NULL
	UNION -- Fuul Outer Join
	SELECT e.employee_id, e.first_name,
		e.department_id, d.department_id,
        d.department_name
    FROM employees e RIGHT OUTER JOIN departments d
		ON e.department_id = d.department_id
        WHERE e.department_id IS NULL;
        
	-- Self Join 동일한 테이블 Join
    SELECT emp.manager_id, mgr.employee_id,
		mgr.first_name
    FROM employees emp, employees mgr
    WHERE emp.manager_id = mgr.employee_id;