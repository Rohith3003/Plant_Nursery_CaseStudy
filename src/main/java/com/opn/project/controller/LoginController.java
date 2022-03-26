package com.opn.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opn.project.bean.Login;
import com.opn.project.dto.LoginDto;
import com.opn.project.service.ILoginService;

@RestController
public class LoginController {
	@Autowired
	ILoginService loginServ;
	
	@PostMapping("/user/login")
	ResponseEntity<LoginDto> addLogin(@Valid @RequestBody Login loginDetails){
		LoginDto login = loginServ.addLogin(loginDetails);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PostMapping("/user/loginNet")
	ResponseEntity<LoginDto> login(@RequestBody Login loginDetails){
		LoginDto login = loginServ.loginNetwork(loginDetails);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@GetMapping("/user/logout/{email}")
	ResponseEntity<LoginDto> logout(@PathVariable("email") String emailId) {
		LoginDto login = loginServ.logoutNetwork(emailId);
		return new ResponseEntity<>(login, HttpStatus.OK);
	};
	
	@GetMapping("/user/resetPassword/{email}")
	ResponseEntity<String> resetPass(@PathVariable("email") String emailId) {
		String mssg =  loginServ.resetPassword(emailId);
		return new ResponseEntity<>(mssg, HttpStatus.OK);
	}
	
	@GetMapping("/user/forgotPassword/{email}")
	ResponseEntity<String> forgotPass(@PathVariable("email") String emailId) {
		String mssg = loginServ.forgotPassword(emailId);
		return new ResponseEntity<>(mssg, HttpStatus.OK);
	}
	
	@PostMapping("/user/changePassword")
	ResponseEntity<LoginDto> changePass(@RequestBody Login loginDetails, String newPass) {
		LoginDto loginChange = loginServ.changePassword(loginDetails, newPass);
		return new ResponseEntity<>(loginChange, HttpStatus.ACCEPTED);
	}
}
