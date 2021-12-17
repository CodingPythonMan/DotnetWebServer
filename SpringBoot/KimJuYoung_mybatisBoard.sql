create table mybatisBoard(
    board_no number,
    title varchar2(100) not null,
    content varchar2(500) null,
    writer varchar2(50) not null,
    reg_date date default sysdate,
    primary key(board_no)
);

create sequence mybatisBoard_seq
start with 1
increment by 1;

create table mybatismember(
    user_no number,
    user_id varchar2(50) not null,
    user_pw varchar2(50) not null,
    user_name varchar2(100) not null,
    coin number(10) default 0,
    reg_date date default sysdate,
    upd_date date default sysdate,
    enabled char(1) default '1',
    primary key(user_no)
);

create table mybatismember_auth(
    user_no number not null,
    auth varchar2(50) not null
);

alter table mybatismember_auth add constraint fk_mybatismember_auth_user_no
foreign key(user_no) references mybatismember(user_no);

create sequence mybatismember_seq
start with 1
increment by 1;