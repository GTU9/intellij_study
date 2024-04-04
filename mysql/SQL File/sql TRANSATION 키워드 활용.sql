#TRANSATION

-- autocommit 비활성화
set autocommit =0;
-- or
set autocommit =off;

-- autocommit 활성화
set autocommit =1;
-- or
set autocommit =on;

-- 트랜잭션 시작
start transaction;

-- 트랜잭션 진행
select * from tbl_menu;
insert into tbl_menu values (null, '오삼불고기', 10000, 4, 'Y');
update tbl_menu set menu_name = '삼오불고기' where menu_code=20;
delete from tbl_menu where menu_code=200;

-- 트랜잭션 종료
commit;
rollback;