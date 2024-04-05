#CAST FUNTIONS

#명시적 형변환 (Explicit Conversion)
-- CAST(expression AS 데이터형식 [(길이)]
-- CONVERT(expression, 데이터형식 [(길이)]
-- 데이터 형식으로 가능한 것에는 BINARY, CHAR, DATE, DECIMAL, JSON, SIGNED, INTEGER, UNSIGNED INTEGER 등이 있음

select avg(menu_price) from tbl_menu;
select cast(avg(menu_price) as signed integer) as '메뉴 평균 가격' from tbl_menu;
select convert(avg(menu_price), signed integer) as '메뉴 평균 가격' from tbl_menu;

select cast('2024/4/5' as date);			-- '/' , '.', '@' 도 구분자로 사용가능

select menu_name, menu_price
from tbl_menu;

select menu_name, concat(cast(menu_price as char(5)), '원') as '메뉴가격'
from tbl_menu;

# 암시적 형변환(Implicit Conversion)

-- 각 문자가 정수로 변환됨
select '1'+'2'; -- 3

select menu_name, concat(menu_price, '원') as '메뉴가격'
from tbl_menu;

-- 문자는 0으로 변환됨
select 3> 'MAY';

-- 문자에서 첫 번쨰로 나온 숫자는 정수로 변환됨
select 5> '6MAY';		-- 0;

-- 첫 번째로 나온 문자는 0으로 변환됨
select 5> 'M6AY';