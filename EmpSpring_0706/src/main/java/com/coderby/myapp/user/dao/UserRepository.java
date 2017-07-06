package com.coderby.myapp.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coderby.myapp.user.model.UserVO;

@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class UserMapper implements RowMapper<UserVO>{ 
		@Override
		public UserVO mapRow(ResultSet rs, int rowCont) throws SQLException{
			UserVO user = new UserVO();
			user.setUserId(rs.getString("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserPassword(rs.getString("user_password"));
			user.setUserRole(rs.getString("user_role"));
			return user;
		}

	}
		
	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(user_id, user_password, user_name, user_role) "
				+ "values(?,?,?,?)";
		jdbcTemplate.update(sql,user.getUserId(),user.getUserPassword(),
				user.getUserName(),user.getUserRole());

	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		String sql =  "update users set user_name = ?, user_password= ?, user_role=? where user_id = ? ";
		jdbcTemplate.update(sql,user.getUserName(), user.getUserPassword(), user.getUserRole(), user.getUserId());

	}

	@Override
	public void deleteUser(String userId, String userPassword) {
		// TODO Auto-generated method stub
		String sql="delete users where user_id=? and user_password=?";
		jdbcTemplate.update(sql,userId, userPassword);
	}

	@Override
	public UserVO selectUser(String userId) {
		// TODO Auto-generated method stub
		String sql="select * from users where user_id=?";
		
		return jdbcTemplate.queryForObject(sql, new UserMapper(),userId);
	}

	@Override
	public List<UserVO> seletAllUser() {
		// TODO Auto-generated method stub
		String sql="select * from users";
		return jdbcTemplate.query(sql, new UserMapper());
	}

	@Override
	public String getPassword(String userId) {
		// TODO Auto-generated method stub
		String sql = "select user_password from users where user_id =?";
		return jdbcTemplate.queryForObject(sql,String.class,userId);
	}

}
