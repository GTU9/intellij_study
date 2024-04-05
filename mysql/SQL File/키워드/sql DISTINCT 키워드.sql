# DISTINCT

-- 단일 열 DISTINCT
select distinct category_code
from
	tbl_menu
order by
	category_code;
    
-- 단일 열 DINSTINCT (컬럼값에 NULL이 포함된 경우)
select distinct ref_category_code
from
	tbl_category;
    
-- 여러 개 열에서의 DISTINCT
select category_code
	 , orderable_status
from
	tbl_menu
order by
	category_code
    , orderable_status;
    

select distinct category_code
	 , orderable_status
from
	tbl_menu
order by
	category_code
    , orderable_status;