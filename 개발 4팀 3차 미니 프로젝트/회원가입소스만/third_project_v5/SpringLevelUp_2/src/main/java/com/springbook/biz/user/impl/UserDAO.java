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
	
	// SQL ��ɾ��
	//private final String USER_GET = "select * from tb_com_user where id=? and pw=?";
	//private final String USER_SignUp = "insert into tb_com_user(id, pw, email, name, birth, phone_num, address, grade) values (?, ?, ?, ?, ?, ?, ?, ?)";
	//private final String USER_Modify = "update tb_com_user set pw = ? where id = ?";

	// CRUD ����� �޼ҵ� ����
	// ȸ�� ���
//	public UserVO getUser(UserVO vo) {
//	}
	
	// ȸ������
	public void insertUser(UserVO vo) {
		System.out.println("===> UserDao�� insertUser() ȣ��");
		try {
		mybatis.insert("UserDAO.insertUser", vo);//user.insertUser�� �ƴ϶� UserDao.insertUser
		//���⼭ UserDao�� @Reoisitiry�� �̸�
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��ȣ����
//	public void updateUser(UserVO vo) {
//		System.out.println("===> JDBC�� updateUser() ��� ó��");
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