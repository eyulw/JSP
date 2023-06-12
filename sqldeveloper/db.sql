drop table member;


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

update member set email='bbb.gmail.com' where id='bbb';

select * from member;
select id from member;
select id,name from member;
select id,name,password from member;

select count(*) as count from member where id='minha';

select * from member where id='hong' and password='5678';

select id,name,address,lpad(zonecode,5,'0'),detailaddress from member;


--auto increment : 자동증가 mysql에는 있는데 oracle에는 없음
create table board(
    id          number primary key,
    name        varchar2(100) not null,
    title       varchar2(300) not null,
    contents    varchar2(3000) not null,
    regdate     date default sysdate,
    hit         number
);

insert into board values(seq_board.nextval,'김민하','제목을 씁니다','내용이 들어갑니다',sysdate,0);

select * from board;