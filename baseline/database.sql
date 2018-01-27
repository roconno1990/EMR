create database if not exists EMR;

use EMR;

drop table if exists USER;
CREATE TABLE USER (
	user_id       int PRIMARY KEY,
	creation_time TIMESTAMP,
	username      VARCHAR(30) not null,
	password      VARCHAR(30) not null,
	role          VARCHAR(30) not null );

drop table if exists VISIT;
CREATE TABLE VISIT (
	update_time   TIMESTAMP,
	patient_id    VARCHAR(30) PRIMARY KEY,
	visit_date    DATE,
	visit_time    TIME,
	reason        VARCHAR(180),
	date_of_birth VARCHAR(15),
    med_rec_ref   VARCHAR(10) not null,
    finance_ref   VARCHAR(10) not null,
    prescriptions VARCHAR(200),
    diagnoses     VARCHAR(100),
    comments      VARCHAR(500),
    FOREIGN KEY(patient_id) REFERENCES PATIENT(patient_id)
);

drop table if exists PATIENT;
CREATE TABLE PATIENT (
    patient_id          VARCHAR(10) PRIMARY KEY,
    update_time         TIMESTAMP,
    first_name          VARCHAR(30) not null,
    middle_name         VARCHAR(30),
    last_name           VARCHAR(30) not null,
    med_rec_ref         VARCHAR(10) not null,
    finance_ref         VARCHAR(10) not null,
    social_Security     VARCHAR(10) not null,
    address             VARCHAR(100),
    attending_physician VARCHAR(30),
    caring_nurse        VARCHAR(30),
    room_num            VARCHAR(10),
    location            VARCHAR(50) );