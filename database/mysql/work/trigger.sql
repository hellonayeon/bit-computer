/*
	trigger: 촉박하다 == callback
    before, after
    
    delimiter $$
		create trigger 트리거명
        { before | after } {insert | update | delete}
            on 테이블명
            for each row
        begin
            쿼리문
        end
    $$ delimiter ;
*/

-- 저장(검사) 테이블
create table dept_update_tb(
	old_name varchar(30),
    new_name varchar(30)
);

delimiter $$
create trigger trigger_test
	-- 부서 테이블을 업데이트 시키기 전에 실행
	before update
    on departments
    for each row
begin
	insert into dept_update_tb(old_name, new_name)
    values(old.department_name, new.department_name); -- old.변경되기 전의 이름
end
$$ delimiter ;

update departments
set department_name = '총괄본부'
where department_id = 300;

select *
from dept_update_tb;