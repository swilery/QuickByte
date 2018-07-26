package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	public Integer insertUser(User user);
	public List<User> selectAllUsers();
	public User selectUserById(Integer id);
	public Boolean deleteUserById(Integer id);
	public User updateUser(User user);
	public User selectUserByUsername(String username);
}
