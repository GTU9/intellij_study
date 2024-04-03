# JOIN

# ALIAS (별칭)
-- 컬럼 별칭
select menu_code as 'code'
	 , menu_name as name
     , menu_price as '메뉴의 가격'
from
	tbl_menu;
    
-- -------------------------------------------
-- 테이블 별칭
select m.menu_code
	 , m.menu_name
	 , m.menu_price
from
	-- tbl_menu as a;
    tml_menu a; -- 테이블 별칭 AS 생략가능

-- -------------------------------------------    
#INNER JOIN
-- INNER JOIN에서 INNER는 생략가능

-- ON 
select a.menu_code
	 , a.menu_name
     , b.category_code
     , b.category_name
from 
	tbl_menu a
join 
	tbl_category b on a.category_code=b.category_code; -- 일치하는 컬럼 찾아 비교 조인
    
-- USING
select a.menu_code
	 , a.menu_name
     , b.category_code
     , b.category_name
from 
	tbl_menu a
join 
	tbl_category b using (category_code); -- 조인하고자 하는 테이블의 컬럼명이 똑같을 떄 조인

-- -------------------------------------------
#OUTER JOIN
-- LEFT JOIN

select b.menu_code
	 , b.menu_name
     , a.category_code
     , a.category_name
from 
	tbl_category a
left join 
	tbl_menu b on a.category_code=b.category_code;

-- -------------------------------------------
-- RIGHT JOIN
select a.menu_code
	 , a.menu_name
     , b.category_code
     , b.category_name
from 
	tbl_menu a
right join 
	tbl_category b on a.category_code=b.category_code;

-- -------------------------------------------
# CROSS JOIN
select a.menu_name
	 , b.category_name
from 
	tbl_menu a
cross join 
	tbl_category b;

-- -------------------------------------------
# SELF JOIN
select a.category_name as '카테고리명'
	 , b.category_name as '상위 카테고리 명'
from 
	tbl_category a
join 
	tbl_category b on a.ref_category_code=b.category_code;
-- where
-- 	a.ref_category_code is not null;

-- -------------------------------------------
# JOIN 알고리즘
-- NESTED LOOP JOIN

-- explain
select /*+ no_hash_join(a)*/ a.menu_name  -- hint절
	 , b.category_name
from
	tbl_menu a
join tbl_category b on a.category_code=b.category_code;

-- HASH JOIN
select /*+ hash_join(a)*/ a.menu_name  -- hint절
	 , b.category_name
from
	tbl_menu a
join tbl_category b on a.category_code=b.category_code;