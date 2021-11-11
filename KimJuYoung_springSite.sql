-- 1. �⺻ �Խ��� ���̺� ����
create table spring_board(
    b_num number not null,
    b_name varchar2(10) not null,
    b_title varchar2(1000) not null,
    b_content clob,
    b_pwd varchar2(18) not null,
    b_date date default sysdate
);

alter table spring_board
add constraint spring_board_pk primary key(b_num);

comment on table spring_board is '�Խ��� ����';
comment on column spring_board.b_num is '�Խ��Ǽ���';
comment on column spring_board.b_name is '�Խ����ۼ���';
comment on column spring_board.b_title is '�Խ�������';
comment on column spring_board.b_content is '�Խ��ǳ���';
comment on column spring_board.b_pwd is '�Խ��Ǻ�й�ȣ';
comment on column spring_board.b_date is '�Խ��ǵ����';

-- 2. �⺻ �Խ��ǿ� ����� ������ ����
create sequence spring_board_seq
start with 1
increment by 1
nocycle;

select b_num,
		b_name, b_title, b_content,
		to_char(b_date, 'YYYY-MM-DD HH24:MI:SS') as b_date
		from spring_board
		where b_num =21;