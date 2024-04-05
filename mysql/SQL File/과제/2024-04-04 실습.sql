#Q1

create table TEAM_INFO(
TEAM_CODE int auto_increment primary key,
TEAM_NAME varchar(255),
TEAM_DETAIL varchar(255),
USE_YN varchar(255),
check (USE_YN in ('Y','N'))
 )engine=INNODB;
 
 describe TEAM_INFO;
 
 insert into TEAM_INFO(TEAM_NAME,TEAM_DETAIL,USE_YN)
 values ('음악감상부', '클래식 및 재즈 음악을 감상하는 사람들의 모임', 'Y'),
		('맛집탐방부', '맛집을 찾아다니는 사람들의 모임', 'N'),
        ('행복찾기부', null, 'Y');
        
select * from TEAM_INFO;

create table MEMBER_INFO(
MEMBER_CODE int auto_increment primary key,
MEMBER_NAME varchar(255),
BIRTH_DATE varchar(255),
DIVISION_CODE int,
DETAIL_INFO varchar(255),
CONCAST varchar(255),
TEAM_CODE int,
ACTIVE_STATUS varchar(255)
)engine=INNODB;

describe MEMBER_INFO;

insert into MEMBER_INFO(MEMBER_NAME, BIRTH_DATE, DIVISION_CODE, DETAIL_INFO, CONCAST, TEAM_CODE, ACTIVE_STATUS)
values  ('송가인', '1999-01-30',1 ,'안녕하세요 송가인입니다~', '010-9494-9494', 1, 'H'),
		('임영웅', '1999-05-03', null, '국민아들 임영웅입니다!', 'hero@trot.com', 1, 'Y'),
        ('태진아', null, null, null, '(1급 기밀)', 3, 'Y');
        
select * from MEMBER_INFO;

#Q2

select count(*) '팀원 수'
from (select e.EMP_NAME
		from employee e, department d, job j
        where e.DEPT_CODE=d.DEPT_ID and e.JOB_CODE=j.JOB_CODE and d.DEPT_TITLE='기술지원부' and j.JOB_NAME='대리'
        union
        select e.EMP_NAME
		from employee e, department d, job j
        where e.DEPT_CODE=d.DEPT_ID and e.JOB_CODE=j.JOB_CODE and d.DEPT_TITLE='인사관리부' and j.JOB_NAME='사원'
        union
		select e.EMP_NAME
		from employee e, department d, job j
        where e.DEPT_CODE=d.DEPT_ID and e.JOB_CODE=j.JOB_CODE and d.DEPT_TITLE like'%영업%' and j.JOB_NAME='부장') emp;
        
#Q3-1
select e.EMP_ID '사원번호', e.EMP_NAME '직원명', e.PHONE'전화번호', d.DEPT_TITLE'부서명', j.JOB_NAME'직급명', e.SALARY'급여'  
from employee e, department d, job j
where e.DEPT_CODE=d.DEPT_ID 
	and e.JOB_CODE=j.JOB_CODE 
	and  d.DEPT_TITLE not like '%영업%' 
	and j.JOB_NAME in ('대리', '차장') 
	and e.SALARY between 2000000 and 3000000; 
    
#Q3-2

#Q3-3


