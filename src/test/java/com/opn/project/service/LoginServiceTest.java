package com.opn.project.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.opn.project.bean.Login;
import com.opn.project.dto.LoginDto;

@SpringBootTest
class LoginServiceTest {

	@Autowired
	ILoginService loginServ;
	
	@Test
	@Disabled
	void addMethod() {
		Login login = new Login();
		login.setEmail("satyamkkh@yahoo.com");
		login.setPassword("password");
		login.setLogin(false);
		
		LoginDto testLogin = loginServ.addLogin(login);
		assertNotEquals(null, testLogin);
		assertEquals("satyamkkh@yahoo.com", testLogin.getEmail());
	}
	
	@Test
	@Disabled
	void loginNetwork() {
		Login login = new Login("satyamkkh@yahoo.com", "password", false);
		
		LoginDto testLogin = loginServ.loginNetwork(login);
		assertNotEquals(null, testLogin);
		assertEquals("satyamkkh@yahoo.com", testLogin.getEmail());
		assertEquals(true, testLogin.isLogin());
	}
	
	@Test
	@Disabled
	void logoutNetwork() {
		Login login = new Login("satyamkkh@yahoo.com", "password", false);
		
		LoginDto testLogin = loginServ.logoutNetwork(login.getEmail());
		assertNotEquals(null, testLogin);
		assertEquals("satyamkkh@yahoo.com", testLogin.getEmail());
		assertEquals(false, testLogin.isLogin());
	}
	
	@Test
	@Disabled
	void resetPass() {
		Login login = new Login("satyamkkh@yahoo.com", "password", false);
		String mssg = loginServ.resetPassword(login.getEmail());
		assertNotEquals(null, mssg);
		assertEquals("Password reset to 12345678. Please change your password as soon as possible!", mssg);
	}
	
	@Test
	@Disabled
	void forgotPass() {
		String mssg = loginServ.forgotPassword("satyamkkh@yahoo.com");
		assertNotEquals(null, mssg);
		assertEquals("Password reset to 12345678. Please change your password as soon as possible!", mssg);
	}
	
	@Test
	@Disabled
	void changePass() {
		Login login = new Login("satyamkkh@yahoo.com", "12345678", false);
		
		LoginDto testLoginPass = loginServ.changePassword(login, "password1");
		assertNotEquals(null, testLoginPass);
		assertEquals("satyamkkh@yahoo.com", testLoginPass.getEmail());
	}
}
