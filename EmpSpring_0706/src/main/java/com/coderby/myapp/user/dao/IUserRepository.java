package com.coderby.myapp.user.dao;

import java.util.List;

import com.coderby.myapp.user.model.UserVO;

public interface IUserRepository {

	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(String userId, String userPassword);
	UserVO selectUser(String userId);
	List<UserVO> seletAllUser();
	String getPassword(String userId);
}
