create tablespace imageshop
datafile 'C:\oradata\imageshop\imageshop_db.dbf'
size 10M
autoextend on
next 5M
maxsize 20M;

alter session set "_ORACLE_SCRIPT"= true;

create user shopadmin
identified by shop1234
default tablespace imageshop
temporary tablespace temp;

grant connect, resource, dba to shopadmin;
grant create view, create synonym to shopadmin;
grant unlimited tablespace to shopadmin;
alter user shopadmin account unlock;