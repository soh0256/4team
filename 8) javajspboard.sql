[root계정의 connection에서 수행]
------먼저 입력되었어야 할 부분------
CREATE USER 'jspexam'@'localhost' IDENTIFIED BY 'jsppw';
CREATE USER 'jspexam'@'%' IDENTIFIED BY 'jsppw';

------회원관련 기능 구동을 위한 기본 sql문(데이터베이스 생성)------
create database board default character set utf8;

------jspexam계정이 board데이터베이스 사용할 권리 부여 ------
GRANT ALL PRIVILEGES ON board.* TO 'jspexam'@'localhost';
GRANT ALL PRIVILEGES ON board.* TO 'jspexam'@'%';

------회원 정보 보관할 member 테이블 생성------
create table board.member(
	memberid varchar(50) primary key,
	name varchar(50) not null,
	password varchar(10) not null,
	regdate datetime not null
) engint InnoDB default character set = utf8;

-------게시글내용과 게시글관련 정보를 담을 테이블 생성------
create table board.article(
	article_no int auto_increment primary key,
	writer_id varchar(50) not null,
	writer_name varchar(50) not null,
	title varchar(255) not null,
	regdate datetime not null,
	moddate datetime not null,
	read_cnt int
) engint InnoDB default character set = utf8;

create table board.article_content(
	article_no int primary key
	content text
) engint InnoDB default character set = utf8;

