package com.springbook.biz.user;

public interface UserService {
	// CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	public UserVO getUser(UserVO vo);
	
	void insertUser(UserVO vo);
	
	void updateUser(UserVO vo);
	
	void deleteUser(UserVO vo);
}
