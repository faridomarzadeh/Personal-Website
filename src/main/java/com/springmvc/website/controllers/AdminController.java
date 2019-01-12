package com.springmvc.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/Admin")
@Controller
public class AdminController {
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String Index()
	{
		return "/admin/index";
	}

}
