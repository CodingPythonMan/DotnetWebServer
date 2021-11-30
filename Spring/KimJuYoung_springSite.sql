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

-- 1. ȸ������ ���̺�
create table spring_member(
    idx number,
    userid varchar2(70) not null,
    userpw varchar2(100) not null,
    username varchar(50) not null,
    pinno varchar2(15) not null,
    email varchar2(70) not null,
    phone varchar2(13) not null,
    joindate date default sysdate,
    constraint spring_member_pk primary key(idx),
    constraint spring_member_uk unique(userid)
);

comment on table spring_member is 'ȸ�� ���̺� ����';
comment on column spring_member.idx is 'ȸ�����̺� ����';
comment on column spring_member.userid is 'ȸ�����̺� ���̵�';
comment on column spring_member.userpw is 'ȸ�����̺� ��й�ȣ';
comment on column spring_member.username is 'ȸ�����̺� �̸�';
comment on column spring_member.pinno is 'ȸ�����̺� �������';
comment on column spring_member.email is 'ȸ�����̺� �̸���';
comment on column spring_member.phone is 'ȸ�����̺� �ڵ�����ȣ';
comment on column spring_member.joindate is 'ȸ�����̺� �����';

-- 2. ȸ�� ���Խ� ����� ȸ����ȣ(������)
create sequence spring_member_seq;

-- 3. �ؽ��Լ� ��Ʈ���� �����ϱ� ���� ���̺�(��й�ȣ ��ȣȭ)
create table security(
    userid varchar2(70),
    salt varchar2(70),
    constraint security_pk primary key(userid)
);

-- 4. �α��� ���� ���� ���̺�
create table login_history(
    idx number,
    userid varchar2(70),
    retry number default 0,
    lastFailedLogin number default 0,
    lastSuccessedLogin number default 0,
    clientip varchar2(15),
    constraint login_history_pk primary key(idx)
);

comment on table login_history is '�α��� ���� ���� ���̺�';
comment on column login_history.idx is '����';
comment on column login_history.userid is '�α��� ���̵�';
comment on column login_history.retry is '�α��� �õ� Ƚ��';
comment on column login_history.lastfailedlogin is '���������� ������ �α��� �ð�';
comment on column login_history.clientip is '�α����� ������� ip �ּ�';

-- 5. �α��� ���� ����� ����� ����(������)
create sequence login_history_seq;