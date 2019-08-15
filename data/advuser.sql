prompt PL/SQL Developer import file
prompt Created on 2019Фъ8дТ15Ше by гугугу
set feedback off
set define off
prompt Creating ADVUSER...
create table ADVUSER
(
  managername VARCHAR2(40),
  password    VARCHAR2(30)
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

prompt Disabling triggers for ADVUSER...
alter table ADVUSER disable all triggers;
prompt Deleting ADVUSER...
delete from ADVUSER;
commit;
prompt Loading ADVUSER...
prompt Table is empty
prompt Enabling triggers for ADVUSER...
alter table ADVUSER enable all triggers;
set feedback on
set define on
prompt Done.
