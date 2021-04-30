package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

// DAO(Data Access Object)
@Repository("userDAO")
public class UserDAO {
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	// SQL ��ɾ��
	private final String USER_GET = "select * from tb_com_user where id=? and pw=?";
	private final String USER_SignUp = "insert into tb_com_user(id, pw, email, name, birth, phone_num, address, grade) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String USER_Modify = "update tb_com_user set pw = ? where id = ?";
	private final String USER_Delete = "DELETE FROM tb_com_user WHERE id=? and pw=?";
	// CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("===> JDBC�� getUser() ��� ó��");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setGrade(rs.getString("GRADE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	// ȸ������
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC�� insertUser() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_SignUp);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			stmt.setString(3, vo.getEmail());
			stmt.setString(4, vo.getName());
			stmt.setString(5, vo.getBirth());
			stmt.setString(6, vo.getPhone_num());
			stmt.setString(7, vo.getAddress());
			stmt.setString(8, vo.getGrade());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// ��ȣ����
	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC�� updateUser() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_Modify);
			stmt.setString(1, vo.getPw());
			stmt.setString(2, vo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// ȸ�� Ż��
	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC�� deleteUser() ��� ó��");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_Delete);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
}