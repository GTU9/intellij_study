# Q1-1
select category_code '카테고리 코드'
	 , category_name '카테고리 명'
from 
	tbl_category
where 
	category_code is not null
order by 
	category_name desc;

#Q1-2
select menu_name '메뉴명'
	 , menu_price '가격'
from 
	tbl_menu
where 
	menu_name like '%밥%' and menu_price between 20000 and 30000;

#Q1-3
select menu_code '메뉴코드'
	 , menu_name '메뉴명'
     , menu_price '메뉴가격'
     , category_code '카테고리 코드'
     , orderable_status '주문가능 상태'
from 
	tbl_menu
where 
	menu_price<10000 or menu_name like '%김치%'
order by 
	menu_price asc, menu_name desc;

#Q1-4
select menu_code '메뉴코드'
	 , menu_name '메뉴명'
     , menu_price '메뉴가격'
     , category_code '카테고리 코드'
     , orderable_status '주문가능 상태'
from 
	tbl_menu
where 
	menu_price=13000
and orderable_status='Y'
and category_code in(select category_code
						from tbl_category
						where 
							category_name not in('기타','커피','쥬스')
                        );

-- -------------------------------------------
#Q2-1
select EMP_ID '사원번호'
	 , EMP_NAME '직원명'
	 , PHONE '전화번호'
     , ENT_DATE '입사일'
     , ENT_YN '퇴직여부'
from 
	employee
where 
	ENT_YN='N' and PHONE like'%2'
limit 3;

#Q2-2
select e.EMP_NAME '직원명'
	 , j.JOB_NAME '직급명' 
     , e.SALARY '급여'
     , e.EMP_ID '사원번호'
     , e.EMAIL '이메일'
     , e.PHONE '전화번호'
     , e.HIRE_DATE '입사일'
from 
	employee e
    , job j
where 
	ENT_YN='N' and e.JOB_CODE=j.JOB_CODE and j.JOB_NAME = '대리'
order by 
	SALARY desc;

#Q2-3
select d.DEPT_TITLE as '부서명'
	, count(*) as '인원'
	, sum(e.SALARY) as '급여합계'
    , avg(e.SALARY) as '급여평균'
from 
	employee e
left join
	department d on e.DEPT_CODE=d.DEPT_ID
where e.ENT_YN='N'
group by 
	d.DEPT_TITLE
 with rollup;

#Q2-4
select e.EMP_NAME '직원명'
	 , e.EMP_NO '주민등록번호'
     , PHONE '전화번호'
	 , d.DEPT_TITLE '부서명'
     , j.JOB_NAME'직급명'
from 
	department d 
    , employee e
    , job j
where 
	e.DEPT_CODE=d.DEPT_ID and e.JOB_CODE=j.JOB_CODE
order by 
	e.HIRE_DATE;

#Q2-5-1
select count(*) '직원의 인원'
from 
	employee
where 
	MANAGER_ID is not null;

#Q2-5-2
select count(*) '직원의 인원'
from 
	employee a
	, employee b
where 
	a.EMP_ID=b.MANAGER_ID;

#Q2-5-3
select a.EMP_NAME '직원명'
	, b.EMP_NAME '관리자의 직원명'
from 
	employee a
left join 
	employee b on a.MANAGER_ID=b.EMP_ID;

#Q2-5-4
select a.EMP_NAME '직원명'
	 , c.DEPT_TITLE '부서명'
     , b.EMP_NAME '관리자의 직원명'
	 , d.DEPT_TITLE '관리자의 부서명'
from 
	employee a
	, employee b
	, department c
    , department d
where 
	a.EMP_ID=b.MANAGER_ID and a.DEPT_CODE=c.DEPT_ID and b.DEPT_CODE=d.DEPT_ID;

-- -------------------------------------------
#Q3-1
select max(max) '가장 큰 액수'
from
	(select sum(e.SALARY) 'max'
	from 
		department d
        , employee e
	where 
		d.DEPT_ID=e.DEPT_CODE
	group by 
		d.DEPT_TITLE)
        as TOTAL_SALARY;
    
#Q3-2
select EMP_ID '사원번호'
	 , EMP_NAME '직원명'
     , DEPT_CODE '부서코드'
     , SALARY '급여'
from 
	employee
where DEPT_CODE in (select DEPT_ID
						from 
							department
						where 
							DEPT_TITLE like '%영업%');
                
#Q3-3
select e.EMP_ID '사원번호'
	 , e.EMP_NAME '직원명'
     , d.DEPT_TITLE'부서명'
	 , e.SALARY '급여'
from 
	employee e
left join 
	department d on e.DEPT_CODE=d.DEPT_ID
where 
	e.DEPT_CODE in (select DEPT_ID
						from 
							department
						where 
							DEPT_TITLE like '%영업%');
                
#Q3-4
select e.EMP_ID'사원번호'
	 , e.EMP_NAME'직원명'
     , e.SALARY '급여'
     , loc.부서명
     , loc.국가명
from 
	employee e
join 
	(select d.DEPT_ID '부서코드'
		  , d.DEPT_TITLE '부서명'
          , l.LOCAL_NAME '지역명'
          , n.NATIONAL_NAME '국가명'
		from 
			nation n
			, department d
		join 
			location l on l.LOCAL_CODE=d.LOCATION_ID
		where 
			l.NATIONAL_CODE=n.NATIONAL_CODE
	) as loc
on loc.부서코드=e.DEPT_CODE
order by 
	loc.국가명 desc;

#Q3-5
select e.EMP_ID'사원번호'
	 , e.EMP_NAME'직원명'
     , e.SALARY '급여'
     , loc.부서명
     , loc.국가명
     , e.SALARY+ g.MIN_SAL '위로금'
from 
	sal_grade g
	, employee e
join 
	(select d.DEPT_ID '부서코드'
		  , d.DEPT_TITLE '부서명'
          , l.LOCAL_NAME '지역명'
          , n.NATIONAL_NAME '국가명'
		from 
			nation n
			, department d
		join 
			location l on l.LOCAL_CODE=d.LOCATION_ID
		where 
			l.NATIONAL_CODE=n.NATIONAL_CODE
	) as loc
on loc.부서코드=e.DEPT_CODE
where 
	loc.국가명='러시아' and g.SAL_LEVEL=e.SAL_LEVEL
order by 
	위로금 desc;


