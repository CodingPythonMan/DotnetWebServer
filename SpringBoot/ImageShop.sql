create table code_group(
    group_code varchar2(3) not null,
    group_name varchar2(30) not null,
    use_yn varchar2(1) default 'Y',
    reg_date date default sysdate,
    upd_date date default sysdate,
    primary key (group_code)
);

create table code_detail(
    group_code varchar2(3) not null,
    code_value varchar2(3) not null,
    code_name varchar2(30) not null,
    sort_seq number not null,
    use_yn varchar2(1) default 'Y',
    reg_date date default sysdate,
    upd_date date default sysdate,
    primary key (group_code, code_value)
);

create table member(
    user_no number(5) not null,
    user_id varchar2(50) not null,
    user_pw varchar2(100) not null,
    user_name varchar2(100) not null,
    job varchar2(3) default '00',
    coin number(10) default 0,
    reg_date date default sysdate,
    upd_date date default sysdate,
    enabled varchar2(1) default '1',
    primary key (user_no)
);

create sequence member_seq
start with 1
increment by 1;

create table member_auth(
    user_no number(5) not null,
    auth varchar2(50) not null
);

alter table member_auth add constraint fk_member_auth_user_no
foreign key(user_no) references member(user_no);

create table persistent_logins(
    username varchar2(64) not null,
    series varchar2(64) not null,
    token varchar2(64) not null,
    last_used date not null,
    primary key (series)
);

-- 회원 게시판
create table board(
    board_no number not null,
    title varchar2(200) not null,
    content varchar2(3000),
    writer varchar2(50) not null,
    reg_date date default sysdate,
    primary key(board_no)
);

create sequence board_seq
start with 1
increment by 1;

create table notice(
    notice_no number not null,
    title varchar2(200) not null,
    content varchar2(3000),
    reg_date date default sysdate,
    primary key(notice_no)
);

create sequence notice_seq
start with 1
increment by 1;

create table item(
    item_id number(10) not null,
    item_name varchar2(30) not null,
    price number(7) not null,
    description varchar2(500) not null,
    picture_url varchar2(200),
    preview_url varchar2(200),
    primary key (item_id)
);

create sequence item_seq
start with 1
increment by 1;

-- 코인 충전 내역 테이블
create table charge_coin_history(
    history_no number(10) not null,
    user_no number(10) not null,
    amount number(10) not null,
    reg_date date default sysdate,
    primary key (history_no)
);

create sequence charge_coin_history_seq
start with 1
increment by 1;

create table user_item(
    user_item_no number(10) not null,
    user_no number(10) not null,
    item_id number(10) not null,
    reg_date date default sysdate,
    primary key(user_item_no)
);

create sequence user_item_seq
start with 1
increment by 1;

create table pay_coin_history(
    history_no number(10) not null,
    user_no number(10) not null,
    item_id number(10) not null,
    amount number(10) not null,
    reg_date date default sysdate,
    primary key(history_no)
);

create sequence pay_coin_history_seq
start with 1
increment by 1;

-- 공개자료 테이블
create table pds(
    item_id number(5) not null,
    item_name varchar2(20),
    view_cnt number(6) default 0,
    description varchar2(50),
    primary key(item_id)
);

create sequence pds_seq
start with 1
increment by 1;

-- 자료파일 테이블
create table pds_attach(
    fullName varchar2(150) not null,
    item_id number(5) not null,
    down_cnt number(6) default 0,
    regdate date default sysdate,
    primary key(fullName)
);