package com.springmvc.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.website.models.Post;
import com.springmvc.website.services.IService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	private IService<Post> service; 
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String Index(Model model)
	{
		model.addAttribute("PostList",service.getAll("Post"));
		return "/admin/index";
	}

}
