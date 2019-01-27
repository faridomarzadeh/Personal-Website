package com.springmvc.website.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.website.models.Menu;
import com.springmvc.website.models.Post;
import com.springmvc.website.services.IService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	private IService<Post> postService; 
	@Autowired
	private IService<Menu>menuService;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String Index(Model model)
	{
		List<Menu> menues=menuService.getAll("Menu");
		for (Menu menu : menues) {
			String query="from Menu where parent_id="+menu.getId();
			menu.setSubMenu(menuService.getResultsByQuery(query));
		}
		model.addAttribute("PostList",postService.getAll("Post"));
		model.addAttribute("menuList", menues);
		return "/admin/index";
	}

}
