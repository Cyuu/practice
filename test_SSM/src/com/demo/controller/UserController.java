package com.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.demo.bean.User;
import com.demo.service.UserService;

@Controller
public class UserController  {
	
	@Resource(name="userService")
	private UserService userService;
	
	// 跳转到登陆页面
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}
	
	// 登陆验证
	@RequestMapping("/login.do")
    public ModelAndView login(String name, String password, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
		User user = new User();
        user.setName(name);
        user.setPassword(password);
		user = userService.findUserByNameAndPassword(user);
		
        if(null != user) {
            //登录成功，将 user 对象存入 session 并跳转到 page/success.jsp 页面
            session.setAttribute("user", user);
            //转发到main请求
            modelAndView.setViewName("success");
        } else {
            //登录失败，设置失败信息，并调转到登录页面
        	modelAndView.setViewName("loginForm");
        }
        return modelAndView;
    }
}