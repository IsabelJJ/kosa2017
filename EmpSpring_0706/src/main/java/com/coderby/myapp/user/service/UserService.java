package com.coderby.myapp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderby.myapp.user.dao.IUserRepository;
import com.coderby.myapp.user.model.UserVO;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		userRepository.insertUser(user);
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String userId, String userPassword) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(userId, userPassword);
	}

	@Override
	public UserVO selectUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.selectUser(userId);
	}

	@Override
	public List<UserVO> seletAllUser() {
		// TODO Auto-generated method stub
		return userRepository.seletAllUser();
	}

	@Override
	public boolean checkPassword(String userId, String userPassword) {
		// TODO Auto-generated method stub
		String dbpw = userRepository.getPassword(userId);
		if(userPassword.equals(dbpw) && dbpw != null){
			return true;
		}
		else {
			return false;
		}
	}

}
