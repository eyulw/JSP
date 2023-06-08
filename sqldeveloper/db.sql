drop table member;

create table member(
    id varchar2(100) not null,
    name varchar2(100) not null,
    password varchar2(100) not null,
    address varchar2(200),
    zipcode int,
    gender varchar(10)
);

create table member(
    id              varchar2(100)   primary key,    --제약조건 primary key -> unique not null
    name            varchar2(100)   not null,
    password        varchar2(100)   not null,
    email           varchar2(100)   not null,
    zonecode        number(5)       not null,
    address         varchar2(300),
    detailaddress   varchar2(100),
    extraaddress    varchar2(100)
);



-- Create(insert) Read(select) Update Delete
insert into member (id , name , password ) values('minha','김민하','1234');
insert into member values('hong','홍길동','5678');

commit;

delete from member where id = 'minha' and password='1234';
-- 이전 commit 상태로 넘어감
rollback;

select * from member;
select id from member;
select id,name from member;
select id,name,password from member;

select count(*) as count from member where id='minha';

select * from member where id='hong' and password='5678';

select id,name,address,lpad(zonecode,5,'0'),detailaddress from member;
