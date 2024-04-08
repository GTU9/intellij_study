#INDEX

create table phone (
	phone_code int primary key,
    phone_name varchar(100) not null,
    phone_price decimal(10,2) not null
);

insert into phone(phone_code, phone_name, phone_price)
values
(1, 'iphone 31 pro', 1700000),
(2, 'galaxyS300', 1900000),
(3, '샤오미 2050', 210000);

select * from phone;

explain
select *
from phone
where phone_name ='iphone 31 pro'
	and phone_price='1700000';
-- INDEX 생성
create index idx_name
on phone (phone_name);

-- INDEX 확인
show index from phone;

-- 복합 INDEX 생성
create index idx_name_price
on phone (phone_name, phone_price);

-- INDEX 최적화(재구성)
alter table phone drop index idx_name;
alter table phone add index index_name (phone_name);
