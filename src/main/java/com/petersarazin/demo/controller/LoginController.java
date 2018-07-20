package com.petersarazin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{
	@GetMapping( "/login" )
	public String loginPage( ModelMap map )
	{
		return "loginDialog";
	}

	@PostMapping( "/login" )
	public String loginPagePost( ModelMap map )
	{
		return "loginDialog";
	}

}
