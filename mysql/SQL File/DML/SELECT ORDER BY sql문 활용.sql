# order by

-- 결과 집합을 하나의 열 기준으로 정렬(오름차순)
select menu_code
	 , menu_name
	 , menu_price
    from tbl_menu
    order by menu_price asc; -- ASC는 오름차순 정렬로, 생략할 수 있음
    
-- ----------------------------------------------
select menu_code
	 , menu_name
     , menu_price
from
	tbl_menu
order by
	menu_price desc; -- DESC는 내림차순 정렬로, 명시해야 함
    
-- ----------------------------------------------
-- 결과 집합을 여러 개의 열로 정렬
select menu_code
	 , menu_name
     , menu_price
from
	tbl_menu
order by
	  menu_price desc
    , menu_name asc;
    
-- ----------------------------------------------
-- 결과 집합을 연산 결과로 정렬(별칭 지정 가능)
select menu_code
	 , menu_name
     , menu_price
     , menu_code * menu_price as '연산결과'
from
	tbl_menu
order by
	연산결과 desc;
    
-- ----------------------------------------------
-- 사용자 지정 목록을 사용하여 정렬
select field('A','A','B','C');
select field('B','A','B','C');

-- -----------------------------------------------
select menu_name
	 , orderable_status
     , field(orderable_status, 'Y', 'N')
from
	tbl_menu;
 -- ----------------------------------------------
select menu_name
	 , orderable_status
from
	tbl_menu
order by
	field(orderable_status,'Y','N') desc;
    
-- ----------------------------------------------
-- NULL
-- 오름차순(ASC) 정렬 시 NULL이 맨처음(default)
select category_code
	 , category_name
     , ref_category_code
from 
	tbl_category
order by
	  ref_category_code is null desc
    , ref_category_code desc;
    