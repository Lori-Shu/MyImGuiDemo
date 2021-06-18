drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   标识                   bigint not null auto_increment,
   用户名                  varchar(255),
   用户密码                 varchar(255),
   primary key (标识)
);
  insert into t_user(用户名,用户密码) values('zs','123');
  insert into t_user(用户名,用户密码) values('ls','333');
  insert into t_user(用户名,用户密码) values('wer','666');
commit;