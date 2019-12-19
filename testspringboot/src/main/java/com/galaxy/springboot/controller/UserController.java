package com.galaxy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.springboot.entity.TbUser;
import com.galaxy.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/list")
	public List<TbUser> list() {
		return userService.selectLists();
	}
	
	@RequestMapping("/add")
	public String add(Integer uid,String username,String password) {
		TbUser user = new TbUser();
		user.setUid(uid);
		user.setUsername(username);
		user.setPassword(password);
		userService.add(user);
		return "成功";
	}
	@RequestMapping("/del")
	public String delete(Integer id) {
		userService.delete(id);
		return "删除成功";
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	
}
