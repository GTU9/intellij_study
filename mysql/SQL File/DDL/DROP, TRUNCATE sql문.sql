#DROP

create table tbl_3(
	pl int auto_increment primary key,
    fk int,
    col1 varchar(255),
    check (col1 in ('Y','N'))
    )engine=INNODB;
    
    create table tbl_4(
	pl int auto_increment primary key,
    fk int,
    col1 varchar(255),
    check (col1 in ('Y','N'))
    )engine=INNODB;
    
select * from tbl_3;

-- DROP TABLE [IF EXISTS] 테이블명1, 테이블명2, ...[RESTRICT | CASCADE];
drop table if exists tbl_3;
    
 select * from tbl_4;
drop table tbl_3, tbl_4, tbl_5;					-- 실행이 안됨
drop table if exists tbl_3, tbl_4, tbl_5;		-- 조건이 맞은 부분은 실행이 됨, 나머지는 경고

# TRUNCATE

create table tbl_5(
	pl int auto_increment primary key,
    fk int,
    col1 varchar(255),
    check (col1 in ('Y','N'))
    )engine=INNODB;

insert into tbl_5 values (null, 10, 'Y');
insert into tbl_5 values (null, 20, 'Y');
insert into tbl_5 values (null, 30, 'Y');
insert into tbl_5 values (null, 40, 'Y');
insert into tbl_5 values (null, 50, 'N');

select * from tbl_5;

truncate tbl_5;
