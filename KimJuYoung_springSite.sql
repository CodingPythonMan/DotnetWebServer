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
        
-- 1. ���̺� ����
create table spring_gallery(
    g_num number not null,
    g_name varchar2(10) not null,
    g_subject varchar2(50 char)not null,
    g_content varchar2(100 char) not null,
    g_thumb varchar2(100) not null,
    g_file varchar2(100) not null,
    g_pwd varchar2(18) not null,
    g_date date default sysdate,
    constraint spring_gallery_pk primary key(g_num)
);

comment on table spring_gallery is '������ �Խ��� ����';
comment on column spring_gallery.g_num is '�������Խ��� ����';
comment on column spring_gallery.g_name is '�������Խ��� �ۼ���';
comment on column spring_gallery.g_subject is '�������Խ��� ����';
comment on column spring_gallery.g_content is '�������Խ��� ����';
comment on column spring_gallery.g_thumb is '�������Խ��� ����� �̹���';
comment on column spring_gallery.g_file is '�������Խ��� �̹���';
comment on column spring_gallery.g_pwd is '�������Խ��� ��й�ȣ';
comment on column spring_gallery.g_date is '�������Խ��� �����';

--2. ������ ����
create sequence spring_gallery_seq;
