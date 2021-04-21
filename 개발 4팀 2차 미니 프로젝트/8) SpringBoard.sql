// 사용자명 : sa , 비밀번호 :   // (H2콘솔 연결 전 설정)

// USERS 테이블 생성
DROP TABLE USERS CASCADE CONSTRAINT;
CREATE TABLE USERS (
     ID VARCHAR2(8) PRIMARY KEY,	// 사용자 아이디
     PASSWORD VARCHAR2(8),	// 사용자 비밀번호
     NAME VARCHAR2(20),		// 사용자 이름
     ROLE VARCHAR2(5)		// 사용자 권한
);

// USERS 테이블 구조 확인
SHOW COLUMNS FROM USERS;

// USERS 테이블에 데이터 삽입
INSERT INTO USERS VALUES('test', 'test123', '관리자', 'Admin');
INSERT INTO USERS VALUES('user1', 'user1', '홍길동', 'User');

// BOARD 테이블 생성
DROP TABLE BOARD CASCADE CONSTRAINT;
CREATE TABLE BOARD(
   SEQ NUMBER(5) PRIMARY KEY,	// 게시글 번호
   TITLE VARCHAR2(200),		// 게시글 제목
   WRITER VARCHAR2(20),		// 게시글 작성자
   CONTENT VARCHAR2(2000),	// 게시글 내용
   REGDATE DATE DEFAULT SYSDATE,	// 게시글 작성 시간
   CNT NUMBER(5) DEFAULT 0	// 조회수
);

// BOARD테이블 구조 확인
SHOW COLUMNS FROM BOARD;

// BOARD 테이블에 데이터 삽입
INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES(1, '가입인사', '관리자', '잘 부탁드립니다...');

//드랍할때 DROP TABLE USERS(대상) CASCADE까지 작성하고 해도됨
