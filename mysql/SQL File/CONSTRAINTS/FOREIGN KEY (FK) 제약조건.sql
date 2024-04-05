# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK, DEFAULT

#FOREIGN KEY (FK)
-- FOREIGN KEY 제약조건에 의해 테이블 간 관계(Relationship) 형성

drop table if exists user_level;
create table user_level(
	level_code int not null unique,
    level_title varchar(25) not null
)engine =INNODB;

drop table if exists user_fk_1;
create table user_fk_1(
    user_no int primary key, 
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255),
    phone varchar(255) not null,
    email varchar(255),
    level_code int,
    constraint level_code_fk1 
    foreign key(level_code) references user_level(level_code) 
)engine=INNODB;

select * from user_level;

insert into user_level
values
(10, '초보'),
(20, '중수'),
(30, '고수');

insert into user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
values
(1, 'user01', 'pass01', '다람쥐', '010-4444-4444', 'squirrel@naver.com', 10),
(2, 'user02', 'pass02', '원숭이', '010-8888-8888', null, 20);

select * from user_fk_1;

-- FOREIGN KEY 제약조건으로 인한 에러 발생 (참조 테이블 컬럼에 없는 값 적용)
insert into user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
values
-- (3, 'user03', 'pass03', '양', '010-5555-5555', 'shepp@naver.com', 50);
(3, 'user03', 'pass03', '양', '010-5555-5555', 'shepp@naver.com', null);

select * from information_schema.table_constraints
where constraint_schema= 'menudb' and table_name= 'user_fk_1';


-- ON UPDATE SET NULL, ON DELETE SET NULL

drop table if exists user_fk_2;
create table user_fk_2(
    user_no int primary key, 
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255),
    phone varchar(255) not null,
    email varchar(255),
    level_code int,
    constraint level_code_fk2
    foreign key(level_code) 
		references user_level (level_code)
        on update set null
        on delete set null
)engine=INNODB;

insert into user_fk_2 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
values
(1, 'user01', 'pass01', '뽀로로', '010-8282-8282', 'pororo@naver.com', 10),
(2, 'user02', 'pass02', '크롱', '010-9595-9595', null, 20);

select * from user_fk_2;

-- 1) 부모 테이블 컬럼 수정
update user_level
set level_code=null
where level_code =10;

select * from user_level;    

-- 2) 부모 테이블의 컬럼 삭제
delete
from user_level
where level_code=20;