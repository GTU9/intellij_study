# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK, DEFAULT

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


#DEFAULT
-- 컬럼 타입이 DATE이면 current_date 사용가능
-- 컬럼 타입이 DATETIME이면 current_time, current)timestamp, now() 모두 사용가능

drop table if exists tbl_default;
create table tbl_default(
	contry_code int not null auto_increment primary key,
    contry_name varchar(255) not null default '한국',
	population varchar(255) not null default '0명',
    add_day date not null default (current_Date),
    add_time datetime not null default (current_time)
)engine=InnoDB;

select * from tbl_default;

-- default 값을 넣어주기 위해 default 사용
insert into tbl_default values(null, default, default, default, default);

-- default 값이 설정된 컬럼을 insert 대상 컬럼에 명시하지 않으면 default 값으로 삽입됨
insert into tbl_default(contry_code) values (null);

-- null 입력시 null삽입됨 (not null 제약조건이 있는 경우 에러 발생)
-- insert into tbl_default values(null, null, null, null, null);