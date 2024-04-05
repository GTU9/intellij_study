# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, check table

# NOT NULL
drop table if exists user_notnull;
create table user_notnull(
	user_no int not null,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender char(3),
    phone varchar(255) not null,
    email varchar(255)
)engine=INNODB;

insert into user_notnull(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
(2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');

select * from user_notnull;
insert into user_notnull(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
(3, 'user03', 'pass03', null, '여', '010-9999-9999', 'hwanghs@kakao.com');

#UNIQUE
drop table if exists user_unique;
create table user_unique(
	user_no int not null unique,
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender char(3),
    phone varchar(255) not null,
    email varchar(255),
    unique(phone)
)engine=INNODB;

insert into user_unique(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
(2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');

select * from user_unique;

insert into user_unique(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
(100, 'user01', 'pass01', '박서준', '남', '010-1234-5679', null);

insert into user_unique(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
(3, 'user03', 'pass03', '한소희', '여', '010-7865-4321', null);

# PRIMARY KEY (PK)
-- NOT NULL + UNIQUE
-- 한 테이블에 한 개만 설정할 수 있음

drop table if exists user_pk;
create table user_pk(
	-- user_no int primary key,
    user_no int, 
    user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    user_name varchar(255) not null,
    gender char(3),
    phone varchar(255) not null,
    email varchar(255),
    constraint user_pk_const primary key(user_no, user_id) 		-- user_pk_const ->제약조건의 이름
)engine=INNODB;

select * from user_pk;

insert into user_pk(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com');

-- PRIMARY KEY 제약조건으로 인해 에러발생 (PK는 NOT NULL)
insert into user_pk(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
-- (null, 'user01', 'pass01', '박서준', '남', '010-1234-5678', null);
(2, 'user02', 'pass02', '박성준', '남', '010-1234-5678', null);

-- PRIMARY KEY 제약조건으로 인해 에러 발생 (PK는 UNIQUE)
insert into user_pk(user_no,  user_id, user_pwd, user_name, gender, phone, email)
values
-- (1, 'user02', 'pass02', '박세준', '남', '010-7865-4321', null);
(1, 'user02', 'pass02', '한세준', '남', '010-7865-4321', null);



