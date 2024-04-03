# 서브쿼리

-- 서브 쿼리1
select category_code
from tbl_menu
where menu_name = '붕어빵초밥';

-- 메인 쿼리1
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu;

-- (WHERE절에 서브쿼리 사용)
-- 서브쿼리1을 활용한 메인쿼리1 : 메뉴명이 붕어빵초방인 메뉴의 카테고리 코드와 동일한 카테고리 코드를 가진 메뉴 출력
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu
where category_code=(select category_code
						from tbl_menu
						where menu_name='붕어빵초밥');
                        
-- (참고) 서브쿼리를 대상으로 IN 연산 등도 사용 가능하다.
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu
where category_code in (select category_code     -- where category_code in (8,4);와 같다.
						from tbl_menu
						where menu_name like '%김치%');

-- -------------------------------------------                        
-- 서브쿼리2
select count(*) as 'count'
from tbl_menu
group by category_code;

-- 메인쿼리2
-- select max(count)
-- from ();

select max(count)
from (select count(*) as 'count'
		from tbl_menu
		group by category_code) as countmenu; -- 서브쿼리를 from절에 사용할떄 반드시 별칭이 필요하다.
        
-- -------------------------------------------
# 상관 서브쿼리
-- 메인쿼리가 서브쿼리의 결과에 영향을 주는 경우

-- 서브쿼리
select avg(menu_price)
from tbl_menu
group by category_code;

-- 메인쿼리
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu;

select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu a
where menu_price > (select avg(menu_price)
					from tbl_menu
                    where category_code= a.category_code
					group by category_code);
                    
-- 상관 서브쿼리는 단독 동작 불가 (에러 발생)
select avg(menu_price)
from tbl_menu
where category_code= a.category_code
group by category_code;

-- -------------------------------------------
# EXISTS
-- 조회 결과가 있을 때 true, 아니면 false

-- 메뉴가 있는 카테고리명만 조회
select category_name
from tbl_category a
where exists(select 1
				from tbl_menu b
                where b.category_code=a.category_code);
                
-- -------------------------------------------
# CTE (Common Table Expressions)
-- 파생 테이블과 비슷한 개념이며 코드의 과독성과 재사용성을 위해 파생 테이블 대신 사용
-- FROM 절에서만 사용 (JOIN이면 JOIN구문에서도 가능)

with menucate as (
	select a.menu_name,b.category_name
    from tbl_menu a
    join tbl_category b on a.category_code=b.category_code
)
select *
from menucate
order by menu_name;