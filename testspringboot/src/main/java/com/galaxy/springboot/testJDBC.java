package com.galaxy.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.galaxy.springboot.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloWorldApplication.class})
public class testJDBC {

	@Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void mySqlTest(){
        String sql = "select uid,username,password from tb_user";
        List<Student> students = jdbcTemplate.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setUid(resultSet.getInt("uid"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                return student;
            }
        });

        for (Student student : students) {
			System.out.println(student.toString());
		}
        
    }
    
    @Test
    public void insert() {
    	String sql = "insert into tb_user (username,password) values ('you','123')";
    	jdbcTemplate.update(sql);
    }
    
    @Test
    public void delete() {
    	String sql = "delete from tb_user where uid = 8";
    	jdbcTemplate.update(sql);
    }

}
