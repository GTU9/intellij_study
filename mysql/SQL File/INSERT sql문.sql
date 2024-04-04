#DML (Data Manipulation Language)
-- 데이터 조작 언어
-- 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE), 삭제(DELETE)하거나, 조회(SELECT)하는 언어

#INSERT
-- INSERT INTO 테이블명 VALUES (모든 컬럼에 대하여 컬럼순으로 삽입할 데이터 나열...);
insert into tbl_menu values (null, '꿔바로우', 18000, 5, 'Y');

select * from tbl_menu;

-- INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬럼명3, ...)
-- VALUES(컬럼명1에 대한 데이터, 컬럼명2에 대한 데이터, 컬러명3에 대한 데이터, ...);
insert into tbl_menu(menu_code, menu_name, menu_price, category_code, orderable_status)
values (null, '돈까스김밥',8000,4, 'Y');

-- NULL 허용 가능한 (NULLABLE) 컬럼이나 AUTO_INCREMENT가 있는 컬럼을 제외하고 INSERT 가능
-- 삽입할 컬럼명을 명시하면 INSERT시 데이터의 순서를 바꾸는 것도 가능
insert into tbl_menu( menu_name, category_code, menu_price, orderable_status)
values ('쉬림프로제파스타',12,21000, 'Y');

insert into tbl_category(category_name)
values('내가좋아하는음식');

select * from tbl_category;

-- MUTI INSERT
insert into tbl_menu
values
	(null, '감자튀김', 3000, 12, 'Y'), 
    (null, '햄버거', 10000, 12, 'Y'), 
    (null, '초콜릿케이크', 9000, 12, 'Y');

select * from tbl_menu;