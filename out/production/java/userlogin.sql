drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   ��ʶ                   bigint not null auto_increment,
   �û���                  varchar(255),
   �û�����                 varchar(255),
   primary key (��ʶ)
);
  insert into t_user(�û���,�û�����) values('zs','123');
  insert into t_user(�û���,�û�����) values('ls','333');
  insert into t_user(�û���,�û�����) values('wer','666');
commit;