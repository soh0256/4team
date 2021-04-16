package article.service;
/*DeleteMessageService.java파일에서 삭제할 메시지를 위해 비밀번호를 입력했을 때,
 잘못된 비밀번호일 경우 예외처리가 필요, 해당 예외처리를 위한 사용자 정의 예외처리 파일이 이것*/
public class InvalidPasswordException extends ServiceException{
	
	public InvalidPasswordException(String message) {
		super(message);
	}

}
