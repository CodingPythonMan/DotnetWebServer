-- 1. 기본 게시판 테이블 생성
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

comment on table spring_board is '게시판 정보';
comment on column spring_board.b_num is '게시판순번';
comment on column spring_board.b_name is '게시판작성자';
comment on column spring_board.b_title is '게시판제목';
comment on column spring_board.b_content is '게시판내용';
comment on column spring_board.b_pwd is '게시판비밀번호';
comment on column spring_board.b_date is '게시판등록일';

-- 2. 기본 게시판에 사용할 시퀀스 생성
create sequence spring_board_seq
start with 1
increment by 1
nocycle;

select b_num,
		b_name, b_title, b_content,
		to_char(b_date, 'YYYY-MM-DD HH24:MI:SS') as b_date
		from spring_board
		where b_num =21;
        
-- 1. 테이블 생성
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

comment on table spring_gallery is '갤러리 게시판 정보';
comment on column spring_gallery.g_num is '갤러리게시판 순번';
comment on column spring_gallery.g_name is '갤러리게시판 작성자';
comment on column spring_gallery.g_subject is '갤러리게시판 제목';
comment on column spring_gallery.g_content is '갤러리게시판 제목';
comment on column spring_gallery.g_thumb is '갤러리게시판 썸네일 이미지';
comment on column spring_gallery.g_file is '갤러리게시판 이미지';
comment on column spring_gallery.g_pwd is '갤러리게시판 비밀번호';
comment on column spring_gallery.g_date is '갤러리게시판 등록일';

--2. 시퀀스 생성
create sequence spring_gallery_seq;
