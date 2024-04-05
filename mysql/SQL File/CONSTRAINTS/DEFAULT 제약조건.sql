# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK, 

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

-- DEFAULT 값을 넣어주기 위해 DEFAULT 사용
insert into tbl_default values(null, default, default, default, default);

-- DEFAULT 값이 설정된 컬럼을 INSERT 대상 컬럼에 명시하지 않으면 DEFAULT 값으로 삽입됨
insert into tbl_default(contry_code) values (null);

-- NULL 입력시 NULL삽입됨 (not null 제약조건이 있는 경우 에러 발생)
-- insert into tbl_default values(null, null, null, null, null);