create table diaBoard(
    board_no number,
    title varchar2(100) not null,
    content varchar2(1000) null,
    writer varchar2(50) not null,
    reg_date date default sysdate,
    primary key(board_no)
);

create sequence diaBoard_seq
start with 1
increment by 1;