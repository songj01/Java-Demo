package com.sjiang2020.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	
	@GetMapping("helloSping")
	public String welcome() {
		return "hello, sping boot!";
	}

}
