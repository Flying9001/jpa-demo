/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/12/26 19:45:36                          */
/*==============================================================*/


drop table if exists rest_user;

/*==============================================================*/
/* Table: rest_user                                             */
/*==============================================================*/
create table rest_user
(
   id                   bigint unsigned not null auto_increment comment '用户 id',
   user_name            varchar(50) not null default '' comment '用户名',
   passcode             varchar(100) not null default '' comment '密码',
   email                varchar(50) not null default '' comment '邮箱',
   user_status          tinyint(4) not null default 1 comment '用户状态,0:所有,不区分状态,1:正常(默认),2:禁止登陆',
   insert_time          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   insert_user_id       bigint not null default 0 comment '添加人用户 id',
   insert_identity      tinyint(4) not null default 1 comment '添加人身份标识,0:前台用户;1:后台用户(默认)',
   update_time          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   update_user_id       bigint not null default 0 comment '修改人用户 id',
   update_identity      tinyint(4) not null default 1 comment '修改人身份标识;0:前台用户;1:后台用户(默认)',
   versions             int not null default 1 comment '版本控制字段(默认1)',
   del_sign             tinyint not null default 0 comment '逻辑删除字段,0正常(默认),1删除',
   primary key (id)
)
ENGINE = INNODB DEFAULT
CHARSET = UTF8MB4;

alter table rest_user comment 'REST示例-用户表';

