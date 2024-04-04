#DDL (Data Definition Language)

# CREATE
-- IF NO EXISTS 적용 시, 기존에 존재하는 테이블을 생성해도 에러를 발생하지 않음
-- 테이블의 컬럼 설정 구문
-- 		컬럼명 자료형(길이) [NOT NULL] [DEFAULT value] [AUTO_INCREMNET] 컬럼제약조건alter

create table if not exists tbl_1(
pk int primary key,
fk int,
col1 varchar(255),
check(col1 in ('Y','N'))		-- 특정 범위 값만 입력받음
) engine=INNODB;

-- 테이블 구조 확인
describe tbl_1;

insert into tbl_1 values(1,10,'Y');

select * from tbl_1;

-- AUTO INCREMNET
create table tbl_2(
pk int auto_increment primary key,
fk int,
col1 varchar(255)
check(col1 in ('Y','N'))
) engine=INNODB;

select * from tbl_2;

insert into tbl_2 values(null,10,'Y');
insert into tbl_2 values(null,20,'N');

select * from tbl_2;

