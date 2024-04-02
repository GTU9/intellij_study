# select from

-- 단일 열 데이터 검색
select menu_name
	from tbl_menu;
    
-- ----------------------------------------------
-- 다중 열 데이터 검색
select menu_code, menu_name, menu_price
	from tbl_menu;
    
-- ----------------------------------------------    
-- 모든 열 데이터 검색
select    menu_code 
		, menu_name 
		, menu_price 
        , category_code 
        , orderable_status
	from 
			tbl_menu;

select * from tbl_menu;

-- ----------------------------------------------
# 연산자
select 6+3; -- from dual
select 6-3; 
select 6*3; 
select 6/3; 
select 6%3; 

-- ----------------------------------------------
# 내장함수 (이후 챕터에서 다룰 내용)
select now();
select concat('홍',' ','길동');

-- ----------------------------------------------
# 컬럼 별칭
select concat('다','-','람쥐') as name;
select concat('원','-','숭이') as 'character name';

-- ----------------------------------------------
select *, '판매중' as '판매구분' from tbl_menu where orderable_status='Y';