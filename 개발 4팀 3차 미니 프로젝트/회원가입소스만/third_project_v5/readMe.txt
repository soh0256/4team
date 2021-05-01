
sqlplus spring/spring

show user;

alter table tb_com_user drop column user_image;  ---DB에 저장하지 않고 드라이브에 업로드만 함
alter table tb_com_user modify post_num varchar(100); --우편번호대신 기본주소로 용도변경

*DB에는 entDate가 들어가있습니다. 그러나 VO객체가 받고 있지 못하는 듯 합니다. 
이 부분 수정에 있어 도움이 필요합니다.

view\board\UserController.java  ===> signUp메서드에서 58줄의 new File("D:/" + fileName)); 부분은
개인 컴퓨터의 사정에 따라 D드라이브가 없는 경우엔 C로 바꿔야 함