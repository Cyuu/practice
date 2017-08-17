package com.demo.dao;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.demo.bean.User;
import com.demo.mapper.UserMapper;

@Repository
public class UserDao {

	@Resource 
	private UserMapper userMapper;
	
	// 根据用户名和密码查找用户
	public User findUserByNameAndPassword(User user) {
		return userMapper.findUserByNameAndPassword(user);
	}
}