package com.coderby.myapp.user.service;

import java.util.List;

import com.coderby.myapp.user.model.UserVO;

public interface IUserService {
	
	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(String userId, String userPassword);
	UserVO selectUser(String userId);
	List<UserVO> seletAllUser();
	boolean checkPassword(String userId,String userPassword);

}
