package com.springbook.biz.user.impl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springbook.biz.user.UserVO;

// DAO(Data Access Object)
@Repository("UserDAO")
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// SQL 명령어들
	//private final String USER_GET = "select * from tb_com_user where id=? and pw=?";
	//private final String USER_SignUp = "insert into tb_com_user(id, pw, email, name, birth, phone_num, address, grade) values (?, ?, ?, ?, ?, ?, ?, ?)";
	//private final String USER_Modify = "update tb_com_user set pw = ? where id = ?";

	// CRUD 기능의 메소드 구현
	// 회원 등록
//	public UserVO getUser(UserVO vo) {
//	}
	
	// 회원가입
	public void insertUser(UserVO vo) {
		System.out.println("===> UserDao의 insertUser() 호출");
		try {
		mybatis.insert("UserDAO.insertUser", vo);//user.insertUser가 아니라 UserDao.insertUser
		//여기서 UserDao는 @Reoisitiry옆 이름
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 암호변경
//	public void updateUser(UserVO vo) {
//		System.out.println("===> JDBC로 updateUser() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(USER_Modify);
//			stmt.setString(1, vo.getPw());
//			stmt.setString(2, vo.getId());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(stmt, conn);
//		}
//	}
	
}