package com.galaxy.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.springboot.entity.TbUser;
import com.galaxy.springboot.mapper.TbUserMapper;
import com.galaxy.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Override
	public List<TbUser> selectLists() {
		// TODO Auto-generated method stub
		return tbUserMapper.selectByExample(null);
	}

	@Override
	public void add(TbUser user) {
		// TODO Auto-generated method stub
		tbUserMapper.insert(user);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		tbUserMapper.deleteByPrimaryKey(id);
	}

}