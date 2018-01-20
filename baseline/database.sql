create database if not exists EMR;

use EMR;

drop table if exists USER;
CREATE TABLE USER (
	user_id       int PRIMARY KEY,
	creation_time TIMESTAMP,
	username      VARCHAR(30) not null,
	password      VARCHAR(30) not null,
	role          VARCHAR(30) not null );