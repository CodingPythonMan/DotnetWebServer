drop table boardex;

create table boardex(
    seq number(5) primary key,
    title varchar2(200),
    writer varchar2(20),
    content varchar2(2000),
    regdate date default sysdate,
    cnt number(5) default 0
);

commit;

select *
from boardex;

create table users(
    id varchar2(8) primary key,
    password varchar2(8) not null,
    name varchar2(20),
    role varchar2(5)
);

insert into users values('test', 'test1234', '°ü¸®ÀÚ', 'Admin');
commit;