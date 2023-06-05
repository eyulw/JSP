drop table member;

create table member(
    id varchar2(100) not null,
    name varchar2(100) not null,
    password varchar2(100) not null,
    address varchar2(200) not null,
    zipcode int not null,
    gender varchar(10) not null
);

-- Create(insert) Read(select) Update Delete
insert into member (id , name , password ) values('minha','±è¹ÎÇÏ','1234');
insert into member values('hong','È«±æµ¿','5678');

commit;
delete from member where id = 'jang';
-- ÀÌÀü commit »óÅÂ·Î ³Ñ¾î°¨
rollback;

select * from member;
select id from member;
select id,name from member;
select id,name,password from member;

select * from member where id='hong' and password='5678';