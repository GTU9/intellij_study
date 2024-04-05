#DML (Data Manipulation Language)
-- 데이터 조작 언어
-- 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE), 삭제(DELETE)하거나, 조회(SELECT)하는 언어

#DELETE
-- DELETE FROM 테이블명 [ 삭제 조건 ];

delete
from tbl_menu
where menu_code=21;

select * 
from tbl_menu
where menu_code=21;

-- LIMIT을 활용한 행 삭제 (offset 지정은 안됨)
delete
	from tbl_menu
order by menu_price
limit 3;

select * from tbl_menu order by menu_price;
