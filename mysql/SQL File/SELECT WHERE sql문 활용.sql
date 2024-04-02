# WHERE

-- 1) 비교 연산자와 WHERE절
-- = : 같음
select menu_name
	 , menu_price
     , orderable_status
from 
	tbl_menu
where 
	orderable_status='Y';
    
-- ----------------------------------------------
select menu_name
	 , menu_price
     , orderable_status
from 
	tbl_menu
where 
	menu_price=10000;

-- ----------------------------------------------    
-- !=, <> : 같지 않음
select menu_name
	 , menu_price
     , orderable_status
from 
	tbl_menu
-- where
	-- orderable_status !='Y';
where
	orderable_status <> 'Y';

-- ----------------------------------------------
-- 대소 비교 연산자
select menu_name
	 , menu_price
     , orderable_status
from 
	tbl_menu
where 
	menu_price>10000;

select menu_name
	 , menu_price
     , orderable_status
from 
	tbl_menu
where 
	menu_price<=20000;

-- 아래처럼 쓰면 에러는 발생하지 않지만, 원하는 값을 추출하진 않음
-- select menu_name
-- 	 , menu_price
--      , orderable_status
-- from 
-- 	tbl_menu
-- where 
-- 	10000<menu_price<=20000;

-- ----------------------------------------------
-- 2) AND
select 1 and 1, 1 and 0,0 and 1, 0 and 0;
select 1 and null, 0 and null, null and null;

select menu_name
	 , menu_price
     , orderable_status
from 
	tbl_menu
where 
	menu_price>10000
and menu_price<=20000;


select menu_name
	 , menu_price
	 , category_code
     , orderable_status
from 
	tbl_menu
where 
	orderable_status='Y'
and category_code=10;

-- ----------------------------------------------
-- 3) OR
select 1 or 1, 1 or 0,0 or 1, 0 or 0;
select 1 or null, 0 or null, null and null;

select menu_name
	 , menu_price
	 , category_code
     , orderable_status
from 
	tbl_menu
where 
	orderable_status='Y'
or category_code=6;

select menu_name
	 , menu_price
	 , category_code
     , orderable_status
from 
	tbl_menu
where 
	menu_price>15000
or category_code=10;

-- ----------------------------------------------
-- <AND와 OR의 우선순위>
select 1 or 0 and 0;
select (1 or 0) and 0;

select menu_name
	 , menu_price
	 , category_code
     , orderable_status
from 
	tbl_menu
where 
	category_code=4
or	menu_price=9000
and	menu_code>10;

-- ----------------------------------------------
-- 4) BETWEEN

select menu_name
	 , menu_price
	 , category_code
     , orderable_status
from 
	tbl_menu
where 
	menu_price between 10000 and 20000;

-- ----------------------------------------------
-- NOT :부정표현
select menu_name
	 , menu_price
	 , category_code
     , orderable_status
from 
	tbl_menu
where 
	menu_price not between 10000 and 20000;
    
-- ----------------------------------------------
-- 5) LIKE
select menu_name
	 , menu_price
from 
	tbl_menu
where 
	menu_name like '%마늘%'
order by 
	menu_name;

-- 메뉴명에 민트를 포함하고,
-- 금액이 10000원 이상이며,
-- category_code가 4인 메뉴의
-- 모든 칼럼을 조회하세요.
    
select * 
from tbl_menu
where menu_name like '%민트%'
and menu_price>=10000
and category_code=4;

-- ----------------------------------------------
-- NOT
select menu_name
	 , menu_price
from 
	tbl_menu
where 
	menu_name not like '%마늘%'
order by 
	menu_name;

-- ----------------------------------------------
-- 6) in
select menu_name, category_code
from tbl_menu
where category_code=4
or category_code=5
or category_code=6
order by category_code;

select menu_name, category_code
from tbl_menu
where category_code in (4,5,6)
order by category_code;

-- ----------------------------------------------
-- NOT
select menu_name, category_code
from tbl_menu
where category_code not in (4,5,6)
order by category_code;

-- ----------------------------------------------
-- 7) IS NULL
select category_code, category_name, ref_category_code
from tbl_category
where ref_category_code is null;

-- ----------------------------------------------
-- NOT (IS NULL)
select category_code, category_name, ref_category_code
from tbl_category
where ref_category_code is not null;
