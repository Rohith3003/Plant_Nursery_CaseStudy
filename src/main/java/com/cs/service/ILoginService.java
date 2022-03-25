package com.cs.service;

import com.cs.bean.Login;

public interface ILoginService 
{
	Login login(Login login);
	Login logout(String email);
}
