# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK, DEFAULT

#CHECK
drop table if exists user_check;
create table user_check (
	user_no int auto_increment primary key,
    user_name varchar(255) not null,
    gender varchar(3) check (gender in ('남', '여')),
    age int check (age>19)
)engine=innodb;

insert into user_check(user_no, user_name, gender, age)
values
(null,'김길동','남',20),
(null,'홍길동','여',22);

select * from user_check;

insert into user_check(user_no, user_name, gender, age)
values
-- (null,'유길동','여성',29);
-- (null,'유길동','여',19);
(null,'유길동','여',29);