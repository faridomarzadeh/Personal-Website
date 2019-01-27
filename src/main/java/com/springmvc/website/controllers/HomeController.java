package com.springmvc.website.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.website.models.Menu;
import com.springmvc.website.services.IService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IService<Menu>menuService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//select public menues which are root
		List<Menu> menues=menuService.getResultsByQuery("From Menu where category='public' and parent_id=null");
		for (Menu menu : menues) {
			String query="from Menu where parent_id="+menu.getId();
			menu.setSubMenu(menuService.getResultsByQuery(query));
		}
		model.addAttribute("menuList",menues);
		return "home";
	}
	
}
