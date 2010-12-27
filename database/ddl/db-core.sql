/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2010-1-14 16:58:06                           */
/*==============================================================*/

create database `book` default character set utf8;

use `book`;

drop table if exists t_book;

drop table if exists t_department;

drop table if exists t_order01;

drop index uq_order_book on t_order01_detail;

drop table if exists t_order01_detail;

drop table if exists t_order02;

drop index uq_order_book on t_order02_detail;

drop table if exists t_order02_detail;

drop table if exists t_order03;

drop index uq_order_book on t_order03_detail;

drop table if exists t_order03_detail;

drop index uq_role_name on t_role;

drop table if exists t_role;

drop table if exists t_store;

drop index uq_store_book_date on t_store_book_sell;

drop table if exists t_store_book_sell;

drop index uq_store_book on t_store_repository;

drop table if exists t_store_repository;

drop index uq_login_name on t_user;

drop table if exists t_user;

drop table if exists t_user_role;

/*==============================================================*/
/* Table: t_book                                                */
/*==============================================================*/
create table t_book
(
   id                   int(11) not null auto_increment,
   isbn_no              varchar(20) not null,
   book_name            varchar(255) not null,
   author               varchar(32),
   publisher            varchar(64),
   publish_date         datetime,
   price                decimal(14,2) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_department                                          */
/*==============================================================*/
create table t_department
(
   id                   int not null auto_increment,
   dep_name             varchar(32) not null,
   dep_desc             varchar(255),
   store_id             int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_order01                                             */
/*==============================================================*/
create table t_order01
(
   id                   int not null auto_increment,
   order_no             char(10) not null,
   store_id             int not null,
   status               varchar(16),
   sync_flag            varchar(16),
   num                  int,
   total_price          decimal(14,2),
   order_date           datetime,
   memo                 varchar(255),
   create_by            varchar(32),
   create_date          datetime,
   modify_by            varchar(32),
   modify_date          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_order01_detail                                      */
/*==============================================================*/
create table t_order01_detail
(
   id                   int not null auto_increment,
   order_id             int not null,
   book_id              int not null,
   num                  int not null,
   price                decimal(14,2) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: uq_order_book                                         */
/*==============================================================*/
create unique index uq_order_book on t_order01_detail
(
   order_id,
   book_id
);

/*==============================================================*/
/* Table: t_order02                                             */
/*==============================================================*/
create table t_order02
(
   id                   int not null auto_increment,
   order_no             char(10) not null,
   store_id             int not null,
   status               varchar(16),
   sync_flag            varchar(16),
   num                  int,
   total_price          decimal(14,2),
   order_date           datetime,
   memo                 varchar(255),
   create_by            varchar(32),
   create_date          datetime,
   modify_by            varchar(32),
   modify_date          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_order02_detail                                      */
/*==============================================================*/
create table t_order02_detail
(
   id                   int not null auto_increment,
   order_id             int not null,
   book_id              int not null,
   num                  int not null,
   price                decimal(14,2) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: uq_order_book                                         */
/*==============================================================*/
create unique index uq_order_book on t_order02_detail
(
   order_id,
   book_id
);

/*==============================================================*/
/* Table: t_order03                                             */
/*==============================================================*/
create table t_order03
(
   id                   int not null auto_increment,
   order_no             char(10) not null,
   store_id             int not null,
   status               varchar(16),
   sync_flag            varchar(16),
   num                  int,
   total_price          decimal(14,2),
   order_date           datetime,
   memo                 varchar(255),
   create_by            varchar(32),
   create_date          datetime,
   modify_by            varchar(32),
   modify_date          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_order03_detail                                      */
/*==============================================================*/
create table t_order03_detail
(
   id                   int not null auto_increment,
   order_id             int not null,
   book_id              int not null,
   num                  int not null,
   price                decimal(14,2) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: uq_order_book                                         */
/*==============================================================*/
create unique index uq_order_book on t_order03_detail
(
   order_id,
   book_id
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   int not null auto_increment,
   role_name            varchar(60) not null default ' ',
   description          varchar(255) default ' ',
   primary key (id)
);

/*==============================================================*/
/* Index: uq_role_name                                          */
/*==============================================================*/
create unique index uq_role_name on t_role
(
   role_name
);

/*==============================================================*/
/* Table: t_store                                               */
/*==============================================================*/
create table t_store
(
   id                   int not null auto_increment,
   store_name           varchar(32) not null,
   status               varchar(16),
   create_by            varchar(32),
   create_date          datetime,
   modify_by            varchar(32),
   modify_date          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_store_book_sell                                     */
/*==============================================================*/
create table t_store_book_sell
(
   id                   int not null auto_increment,
   store_id             int not null,
   book_id              int not null,
   sale_date            date not null,
   sale_num             int not null,
   sale_total           decimal(14,2) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: uq_store_book_date                                    */
/*==============================================================*/
create unique index uq_store_book_date on t_store_book_sell
(
   store_id,
   book_id,
   sale_date
);

/*==============================================================*/
/* Table: t_store_repository                                    */
/*==============================================================*/
create table t_store_repository
(
   id                   int not null auto_increment,
   store_id             int not null,
   book_id              int not null,
   date                 datetime not null,
   num                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Index: uq_store_book                                         */
/*==============================================================*/
create unique index uq_store_book on t_store_repository
(
   store_id,
   book_id
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int(11) not null auto_increment,
   login_name           varchar(32) not null,
   password             varchar(64),
   name                 varchar(32) not null,
   email                varchar(64),
   status               varchar(16),
   create_by            varchar(32),
   create_date          datetime,
   modify_by            varchar(32),
   modify_date          datetime,
   store_id             int,
   primary key (id)
);

/*==============================================================*/
/* Index: uq_login_name                                         */
/*==============================================================*/
create unique index uq_login_name on t_user
(
   login_name
);

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   user_id              int(11) not null,
   role_id              int not null,
   primary key (role_id, user_id)
);

