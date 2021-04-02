package chapter15.ioadd;

import java.io.File;

public class Test08_FileDelete {
	public static void main(String[] args) {
		if(args.length !=1) {//만약 args.length가 1이 아닌경우(!=1):인수(args) 값이 있을경우 
			System.out.println("파일 또는 (파일없는)디텍도리 삭제 프로그램 사용");
		}
		//delete를 호출하고 발생하는 모든 메시지 출력
		try {
			delete(args[0]);//삭제하는 정적 메소드
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("파일 삭제 완료");
	}
	//삭제를 하는 정적 메소드
	//지정한 파일이나 디렉토리를 삭제하기전 삭제가 가능한지 먼저확인 문제시 예외발생
	public static void delete(String filname) {
		//파일 이름을 나타내기 위해, file객체를 생성함
		File f=new File(filname);
		//파일이나 디렉토리가 존재하는지 와 쓰기 방지가 되어 있는지를 확인
		if(!f.exists())fail("Delete : no such file or directory : "+filname);
		if(!f.canWrite())fail("Delete : write protected : "+filname);
		//디렉토리이면, 비어있는지 확인
		if(f.isDirectory()) {
			String[] files=f.list();
			if(files.length>0)
				fail("Delete : directory not empty :"+filname);
		}
		boolean success =f.delete();//모든 검사를 통과하지 못하면 삭제
		if(!success)fail("Delete : deletion failed");
	}//IllegalArgumentException:부적절한 인수(인수)를 메서드에 처리할 경우 예외처리
	protected static void fail(String msg)throws IllegalArgumentException{
		throw new IllegalArgumentException(msg);
	}
}
