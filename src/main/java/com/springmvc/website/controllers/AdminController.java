package com.springmvc.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.website.services.PostService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	private PostService postservice; 
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String Index(Model model)
	{
		model.addAttribute("PostList",postservice.ListPosts());
		return "/admin/index";
	}

}
