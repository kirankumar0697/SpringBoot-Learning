package com.app.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gottoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		
	return "welcome";
	}
	
	private String getLoggedinUsername()  {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
	
	
	
	//@Autowired
//	private AuthenticationService authService;
//	
//	
//	public LogInController(AuthenticationService authService) {
//		super();
//		this.authService = authService;
//	}

	//private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@RequestMapping("login")
//	public String gottoLogInPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		//logger.info("Requested Param is {}", name);
//		
//		return "logIn";
//	}
	
		
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String gottoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		model.put("name", name);
//		model.put("password", password);
//		
//		if(authService.authenticateLogin(name, password)) {
//			return "welcome";
//		}
//		
//		model.put("invalidCred", "Invalid Credentials! Please try again.");
//		
//		return "logIn";		
//	}
	
}
