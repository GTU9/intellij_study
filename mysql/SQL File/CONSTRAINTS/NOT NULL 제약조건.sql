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