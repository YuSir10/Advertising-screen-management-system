prompt PL/SQL Developer import file
prompt Created on 2019Фъ8дТ15Ше by гугугу
set feedback off
set define off
prompt Creating ADVTERMINAL...
create table ADVTERMINAL
(
  ipadress VARCHAR2(20)
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

prompt Disabling triggers for ADVTERMINAL...
alter table ADVTERMINAL disable all triggers;
prompt Deleting ADVTERMINAL...
delete from ADVTERMINAL;
commit;
prompt Loading ADVTERMINAL...
prompt Table is empty
prompt Enabling triggers for ADVTERMINAL...
alter table ADVTERMINAL enable all triggers;
set feedback on
set define on
prompt Done.
