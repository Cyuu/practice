package com.demo.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.demo.bean.User;
import com.demo.dao.UserDao;

@Service
public class UserService {

	@Resource()
	private UserDao userDao;
	
	// 根据用户名和密码查找用户
	public User findUserByNameAndPassword(User user) {
		return userDao.findUserByNameAndPassword(user);
	}
}