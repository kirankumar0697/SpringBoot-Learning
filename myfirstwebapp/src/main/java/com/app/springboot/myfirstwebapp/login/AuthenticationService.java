package com.app.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticateLogin(String name, String password) {
		
		boolean isValidUsername = "kiran".equalsIgnoreCase(name);
		boolean isValidPassword = "pass".equalsIgnoreCase(password);
		
		return isValidUsername && isValidPassword;
	}
}
