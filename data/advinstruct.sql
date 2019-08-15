prompt PL/SQL Developer import file
prompt Created on 2019Фъ8дТ15Ше by гугугу
set feedback off
set define off
prompt Creating ADVINSTRUCT...
create table ADVINSTRUCT
(
  advno        NUMBER,
  managername  VARCHAR2(40),
  instructname VARCHAR2(30),
  advtime      VARCHAR2(30),
  ipadress     VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for ADVINSTRUCT...
alter table ADVINSTRUCT disable all triggers;
prompt Deleting ADVINSTRUCT...
delete from ADVINSTRUCT;
commit;
prompt Loading ADVINSTRUCT...
prompt Table is empty
prompt Enabling triggers for ADVINSTRUCT...
alter table ADVINSTRUCT enable all triggers;
set feedback on
set define on
prompt Done.
