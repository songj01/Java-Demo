package com.sjiang2020.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public ModelAndView getLoginInPage() {
		
		String message = "hello login in";
		return new ModelAndView("login", "data",message);
	}
     
}
