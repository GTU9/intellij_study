#UNITON 중복제거
select menu_code, menu_name, menu_price, category_code
from tbl_menu
where category_code=10
union
select menu_code, menu_name, menu_price, category_code
from tbl_menu
where menu_price>9000;

#UNION ALL 중복허용
select menu_code, menu_name, menu_price, category_code
from tbl_menu
where category_code=10
union all
select menu_code, menu_name, menu_price, category_code
from tbl_menu
where menu_price>9000;

#INTERSECT
-- MySQL은 INTERSECT를 제공하지 않음
-- 단, INNER JOIN또는 IN을 활용해 구현할 수 있음alter

-- 1)INNER JOIN
select a.menu_code, a.menu_name, a.menu_price, a.category_code
from tbl_menu a
join(select menu_code, menu_name, menu_price, category_code
		from tbl_menu
		where menu_price<9000) b on a.menu_code=b.menu_code
where a.category_code=10;

-- 2)insert
select menu_code, menu_name, menu_price, category_code
from tbl_menu
where category_code=10
AND menu_code in (select menu_code
		from tbl_menu
		where menu_price<9000);
        
# MINUS
-- MySQL은 MINUS를 제공하지 않음
-- 단, LEFT JOIN을 통해 구현 가능
select a.menu_code, a.menu_name, a.menu_price, a.category_code
from tbl_menu a
left join(select menu_code, menu_name, menu_price, category_code
		from tbl_menu
		where menu_price<9000) b on a.menu_code=b.menu_code
where a.category_code=10
and b.menu_code is null;

