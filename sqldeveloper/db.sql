drop table member;

    --�������� primary key -> unique not null
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
insert into member (id , name , password ) values('minha','�����','1234');
insert into member values('hong','ȫ�浿','5678');

commit;

alter table member add profile varchar2(100);
alter table member add realprofile varchar2(100);

delete from member where id = 'minha' and password='1234';
-- ���� commit ���·� �Ѿ
rollback;

update member set email='bbb.gmail.com' where id='bbb';

select * from member;
select id from member;
select id,name from member;
select id,name,password from member;

select count(*) as count from member where id='minha';

select * from member where id='hong' and password='5678';

select id,name,address,lpad(zonecode,5,'0'),detailaddress from member;


--auto increment : �ڵ����� mysql���� �ִµ� oracle���� ����
create table board(
    id          number primary key,     --���� ������ȣ
    userId      varchar2(100) not null,     --member id�� ���� ��ȸ
    name        varchar2(100) not null,
    title       varchar2(300) not null,
    contents    clob not null,
    regdate     date default sysdate,
    hit         number,
    constraint fk_userid foreign key(userId) references member(id)
    --constraint (���� ���ϴ� fk�̸�) foreign key(���� ���̺� �÷���) references �ٸ����̺��(�ٸ����̺��÷���)
);

insert into board values(seq_board.nextval,'minha','�����','������ ���ϴ�','������ ���ϴ�',sysdate,0);

drop table board;

select * from board;

select * from board order by id desc;

delete from board;

update board set hit = hit + 1 where id = ?;

--��������
select * from (select rownum as no, b.* from (select * from board order by id desc) b) where no >=1 and no <=10;

select * from (select rownum as no,board.* from board order by id desc) where no >=1 and no <=10;

select count(*) from board;


rollback;

commit;

create table replyBoard(
    id          number primary key,     --����� ������ȣ
    userId      varchar2(100) not null,     --member id�� ���� ��ȸ
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
    --constraint (���� ���ϴ� fk�̸�) foreign key(���� ���̺� �÷���) references �ٸ����̺��(�ٸ����̺��÷���)
);

--null ����ϰ���������� nvl(,) �տ��ִ°� null�̸� 0�� �־��
select nvl(max(regroup),0) as regroupmax from replyboard;

select * from replyboard;

rollback;
-- ���ۿ� ���� ����� �� �� ���� ���� regroup���� relevel�� 1 ������Ų��.
update replyboard set relevel = relevel +1 where regroup = 1 and relevel >0;

select rownum as no, b.* from (select * from replyboard order by regroup desc,relevel asc) b;

delete from replyboard;

commit;