package com.springbook.biz.user;

public interface UserService {
	// CRUD ����� �޼ҵ� ����
	// ȸ�� ���
	public UserVO getUser(UserVO vo);
	
	public void insertUser(UserVO vo);
	
	public	void updateUser(UserVO vo);
	
	public void deleteUser(UserVO vo);
}
