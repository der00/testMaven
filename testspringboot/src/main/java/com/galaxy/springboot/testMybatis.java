package com.galaxy.springboot;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.galaxy.springboot.entity.TbUser;
import com.galaxy.springboot.mapper.TbUserMapper;

@RunWith(SpringRunner.class)
@MapperScan(basePackages= {"com.galaxy.springboot.mapper"})
@SpringBootTest(classes= {HelloWorldApplication.class})
public class testMybatis {

	@Resource
	private TbUserMapper tbUserMapper;
	
	@Test
	public void mybatisTest() {
		List<TbUser> lists = tbUserMapper.selectByExample(null);
		for(TbUser tbUser : lists) {
			System.out.println(tbUser);
		}
	}
}
