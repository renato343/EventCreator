§drop database if exists db;
create database user_db;
use user_db;

create table user_list(
 user_id integer auto_increment
 name char(15),
 password char(8),
 primary key (user_id)
);