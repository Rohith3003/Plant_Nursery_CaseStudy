package com.opn.project.service;

import com.opn.project.bean.Login;
import com.opn.project.dto.LoginDto;

public interface ILoginService {
	LoginDto addLogin(Login addL);
	LoginDto loginNetwork(Login loginDetails);
	LoginDto logoutNetwork(String emailId);
	String resetPassword(String emailId);
	String forgotPassword(String emailId);
	LoginDto changePassword(Login loginDetails, String newPass);
}
