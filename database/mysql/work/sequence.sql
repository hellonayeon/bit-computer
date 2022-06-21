/*
	sequence : 중복되지 않는 증가숫자
*/

-- sequence table create

drop table if exists sequences;

create table sequences(
	name varchar(32),
    currval bigint unsigned
)engine=InnoDB;

-- 시퀀스를 생성하는 프로시저 생성

drop procedure if exists create_sequence;
drop function if exists nextval;

delimiter $$
create procedure create_sequence(in the_name text)
modifies sql data
deterministic
begin
	delete from sequences where name=the_name;
    insert into sequences values(the_name, 0);
end$$

create function nextval(the_name varchar(32)) returns bigint unsigned
modifies sql data
deterministic
begin
	declare ret bigint unsigned;
    
    update sequences set currval=currval+1 where name=the_name;    
    select currval into ret from sequences where name=the_name limit 1;
    
	return ret;
end$$

delimiter ;

insert into sequences
values('myseq', 0);

-- nextval 값을 가져오기
select nextval('myseq') 
from dual;

SET SQL_SAFE_UPDATES = 0






