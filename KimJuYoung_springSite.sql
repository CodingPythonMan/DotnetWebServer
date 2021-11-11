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