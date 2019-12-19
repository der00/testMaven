package com.galaxy.springboot.service;

import java.util.List;

import com.galaxy.springboot.entity.TbUser;

public interface UserService {

	List<TbUser> selectLists();
	
	void add(TbUser user);
	
	void delete(Integer id);
}