drop table member;

    --제약조건 primary key -> unique not null
create table member(
    id              varchar2(100)   primary key,
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

alter table member add profile varchar2(100);
alter table member add realprofile varchar2(100);

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
    id          number primary key,     --글의 고유번호
    userId      varchar2(100) not null,     --member id를 통한 조회
    name        varchar2(100) not null,
    title       varchar2(300) not null,
    contents    clob not null,
    regdate     date default sysdate,
    hit         number,
    constraint fk_userid foreign key(userId) references member(id)
    --constraint (내가 정하는 fk이름) foreign key(현재 테이블 컬럼명) references 다른테이블명(다른테이블컬럼명)
);

insert into board values(seq_board.nextval,'minha','김민하','제목을 씁니다','내용이 들어갑니다',sysdate,0);

drop table board;

select * from board;

select * from board order by id desc;

delete from board;

update board set hit = hit + 1 where id = ?;

--서브쿼리
select * from (select rownum as no, b.* from (select * from board order by id desc) b) where no >=1 and no <=10;

select * from (select rownum as no,board.* from board order by id desc) where no >=1 and no <=10;

select count(*) from board;


rollback;

commit;

create table replyBoard(
    id          number primary key,     --댓글의 고유번호
    userId      varchar2(100) not null,     --member id를 통한 조회
    name        varchar2(100) not null,
    title       varchar2(300) not null,
    contents    clob not null,
    regdate     date default sysdate,
    hit         number,
    regroup       number not null,
    relevel       number not null,
    restep        number not null,
    available     number(1) default 1,
    constraint fk02_userid foreign key(userId) references member(id)
    --constraint (내가 정하는 fk이름) foreign key(현재 테이블 컬럼명) references 다른테이블명(다른테이블컬럼명)
);

drop table replyBoard;

--nvl,max 오라클 내장 함수 다른데 있을수도있고 없을수도있다.
--null 출력하고싶지않으면 nvl(,) 앞에있는게 null이면 0을 넣어라
select nvl(max(regroup),0) as regroupmax from replyboard;

select * from replyboard;

rollback;
-- 원글에 대한 댓글을 쓸 때 내가 가진 regroup안의 relevel은 1 증가시킨다.
update replyboard set relevel = relevel +1 where regroup = 1 and relevel >0;

select rownum as no, b.* from (select * from replyboard order by regroup desc,relevel asc) b;

-- like %글% : ~글~ 들어가는거 다 찾기 like 글 : 글만 들어가는거 찾기 
select * from replyboard where contents like '%글%';

select * from replyboard;

delete from replyboard;


select * from (select rownum as no, b.* from (
    	select * from replyboard where name like '%인%' order by regroup desc,relevel asc
    ) b) where no >= 1 and no <= 10;

commit;