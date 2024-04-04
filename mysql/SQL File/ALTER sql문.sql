#ALTER

describe tbl_2;

-- 열(컬럼) 추가
alter table tbl_2
add col2 int not null;

-- 열 삭제
alter table tbl_2
drop column col2;

-- 열 이름 및 데이터 형식 변경
alter table tbl_2
change column fk change_fk decimal not null;

-- 열 제약 조건 추가 및 삭제
alter table tbl_2
drop primary key;

-- MODIFY -> 수행 후 다시 위의 제약 조건 삭제 구문 수행
alter table tbl_2
modify pk int;

-- 다시 제약조건 추가
alter table tbl_2
add primary key(pk);

-- 컬럼 여러 개 추가
-- ALTER TABLE 테이블명
-- 		ADD 컬럼명 컬럼정의 [FIRST | AFTER 컬럼명]
-- 		ADD 컬럼명 컬럼정의 [FIRST | AFTER 컬럼명]
-- 		...;

alter table tbl_2
add col3 date not null,
add col4 tinyint not null;

-- ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION
select @@global.sql_mode; 