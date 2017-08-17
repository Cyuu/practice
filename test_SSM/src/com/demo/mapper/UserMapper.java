package com.demo.mapper;

import com.demo.bean.User;

public interface UserMapper { 
	
	// 根据用户名和密码查找用户
	public User findUserByNameAndPassword(User user);
}