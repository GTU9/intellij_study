# REPLACE
-- PRIMARY KEY 또는 UNIQUE KEY에 대해 중복값을 INSERT하면 충돌(에러) 발생
-- insert into tbl_menu values (2,'떡볶이', 2000, 4, 'Y');

replace into tbl_menu values (2,'로제떡뽁이', 122000, 4, 'Y');

-- REPLACE는 중복값에 대해서는 데이터를 엎어쓰고, 중복값이 없다면 INSERT함
-- INTO 키워드는 생략 가능
replace tbl_menu values (200,'복날삼계탕', 15000, 4, 'Y');

select * from tbl_menu order by menu_code;