# GROUP BY
-- COUNT 함수 활용 (카테고리별 메뉴 갯수 카운트)
select category_code, count(*) -- 1이나 *을 사용해도 결과는 똑같다.
from tbl_menu
group by category_code;

-- -------------------------------------------
-- SUM 함수 활용 (카테고리별 메뉴 가격 합계)
select category_code, sum(menu_price) 
from tbl_menu
group by category_code;

-- -------------------------------------------
-- AVG 함수 활용 (카테고리별 메뉴 가격 평균)
select category_code, avg(menu_price)
from tbl_menu
group by category_code;

-- 2개 컬럼으로 그룹 생성
select category_code, menu_price, count(*)
from tbl_menu
group by category_code, menu_price;

-- -------------------------------------------
#HAVING
select category_code, count(*)
from tbl_menu
group by category_code
having category_code between 5 and 8;


-- -------------------------------------------
# ROLLUP
-- 컬럼 한 개를 활용해 GROUP BY 후, ROLLUP -> 총계
-- (카테고리별 가격의 총합 = 메뉴 가격의 총합)
select category_code, sum(menu_price)
from tbl_menu
group by category_code
with rollup;

-- 컬럼 두개를 활용해 GROUP BY 후, ROLLUP -> 중계 + 총계
-- 먼저 나온 컬럼의 총합을 구하고, 이후에 나오는 컬럼의 총합까지도 구하는 방식
select category_code, menu_price, sum(menu_price)
from tbl_menu
group by category_code, menu_price
with rollup;