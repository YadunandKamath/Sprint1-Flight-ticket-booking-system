package com.capg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dao.IUserDao;
import com.capg.entities.User;

@SpringBootTest
class UserTest {
	@Autowired
	IUserDao userDao;
	
	@Test
	void testInjection() {
		assertThat(userDao).isNotNull();
	}
	
	@Test
	void test() {
		User u=new User(001, "personA", "lastA", "A@gmail.com", "##44", "9156666666");
		userDao.save(u);
		assertEquals(userDao.findById(001).get().toString(),u.toString());
	}
	
}
