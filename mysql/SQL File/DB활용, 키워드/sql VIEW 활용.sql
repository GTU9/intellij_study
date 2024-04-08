#VIEW
-- SELECT 쿼리문을 저장한 객체로 '가상 테이블' 이라고 불린다.
-- 실질적인 데이터를 물리적으로 저장하고 있지는 않으나, 테이블을 사용하는 것과 동일하게 사용할 수 있다.

-- VIEW 생성
create view hansik
as
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu
where category_code =4;

-- VIEW 조회
select * from hansik;

-- 베이스 테이블의 정보가 변경되면 VIEW의 결과도 같이 변경된다.
insert into tbl_menu(menu_code, menu_name, menu_price, category_code, orderable_status)
values (null, '세상제일맛있는국밥', 198789, 4, 'Y');

select * from tbl_menu;

-- VIEW를 통한 DML
-- 1) INSERT
insert into hansik
values( null, '세상제일맛있는국밥', 198789, 4, 'Y');

-- 2) UPDATE
update hansik
	set menu_name='오색찬란비빔밥'
		, menu_price =12000
	where menu_code=204;
    
-- 3) DELETE
delete
from hansik
where menu_code =204;

select * from hansik;
select * from tbl_menu;


-- VIEW 삭제
drop view hansik;

-- SUBQUERY, JOIN, 연산 결과 컬럼 등 사용 가능
create view hansik
as
select m.menu_name as '메뉴명', truncate(m.menu_price/1000,1) as '가격(천원)', c.category_name as '카테고리명'
from tbl_menu m
join tbl_category c on m.category_code= c.category_code
where c.category_name='한식';

select * from hansik;

-- OR REPLACE 옵션
-- DROP하지 않고 기존 VIEW를 새로운 VIEW 로 대체할 수 있다.
create or replace view hansik
as
select menu_code as '메뉴코드', menu_name as '메뉴명', category_name as '카테고리명'
from(
		select concat(m.menu_code, '번') as 'menu_code', m.menu_name, concat(c.category_name, '류') as 'category_name'
        from tbl_menu m
        join tble_category c on m.category_code=c.category_code
        where c.category_name='중식'
	) as sub_tbl;
    
select * from hansik;
        