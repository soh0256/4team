[root계정의 connection에서 수행]
------먼저 입력되었어야 할 부분, 계정 생성------
CREATE USER 'jspexam'@'localhost' IDENTIFIED BY 'jsppw';
CREATE USER 'jspexam'@'%' IDENTIFIED BY 'jsppw';

------회원관련 기능 구동을 위한 기본 sql문(데이터베이스 생성)------
create database board default character set utf8;

------jspexam계정이 board데이터베이스 사용할 권리 부여 ------
GRANT ALL PRIVILEGES ON board.* TO 'jspexam'@'localhost';
GRANT ALL PRIVILEGES ON board.* TO 'jspexam'@'%';

------회원 정보 보관할 member 테이블 생성------
drop table board.member cascade constraint;
create table board.member(
	memberid varchar(50) primary key,		#회원아이디
	name varchar(50) not null,			#회원이름
	password varchar(10) not null,		#비밀번호
	regdate datetime not null			#회원가입 시간
)engine=InnoDB default character set = utf8;

-------게시글내용과 게시글관련 정보를 담을 테이블 생성------
drop table board.article cascade constraint;
create table board.article(
	article_no int auto_increment primary key,	#게시글 번호
	writer_id varchar(50) not null,		#작성자 아이디
	writer_name varchar(50) not null,		#작성자 이름
	title varchar(255) not null,			#게시글 제목
	regdate datetime no null,			#최초 작성 일시
	moddate datetime not null,			#마지막 수정 일시
	read_cnt int				#조회수
)engine=InnoDB default character set = utf8;

-------사용자가 작성한 게시글 내용 담을 테이블 생성------
drop table board.article_content cascade constraint;
create table board.article_content(
	article_no int primary key,			#게시글 번호
	content text				#게시글 내용
)engine=InnoDB default character set = utf8;

