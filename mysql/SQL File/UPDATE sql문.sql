#UPDATE
-- UPDATE 테이블명
-- SET 컬럼명1 = 수정할 데이터
--     컬럼명2 = 수정할 데이터
-- [ WHERE 수정 대상 데이터 조건]
update tbl_menu
	set menu_name='오늘점심맛있다.' 
		, menu_price =1000
where menu_code = 21;

select * from tbl_menu where menu_code = 21;

-- MySQL은 UPDATE나 DELETE시 자기 자신 테이블의 데이터를 사용하면 1093 에러 발생
update tbl_menu
	set menu_name='오늘저녁밥'
where menu_code=(select tmp.menu_code
					from(select menu_code
							from tbl_menu
							where menu_name='오늘점심맛있다.') tmp
                    );
                    
