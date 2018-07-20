package com.petersarazin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserHomeController
{
	@RequestMapping( "/userHome" )
	public ModelAndView userHome()
	{
		return new ModelAndView( "userHome" );
	}

}
