package com.qcjk.cms.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class LoginController {
	
	@RequestMapping("/loginIn")
	public String loginIn(){
		
		return "111";
	}
	
	

}
