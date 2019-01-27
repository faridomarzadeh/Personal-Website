package com.springmvc.website.controllers;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.website.models.Role;
import com.springmvc.website.models.User;
import com.springmvc.website.services.IService;
import com.springmvc.website.services.SecurityService;
import com.springmvc.website.validators.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private IService<User>userService;
	@Autowired
	private IService<Role>roleService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm",new User());
		return "registration";
	}
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String registration(@ModelAttribute("userForm")User userForm,BindingResult bindingResult,Model model)
	{
		System.out.println("********************************");
		//userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors())
		{
			System.out.println("****------------------");
			return "registration";
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		userForm.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
		userForm.setRoles(new HashSet<Role>(roleService.getAll("Role")));
		userService.add(userForm);
		
		
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		return "redirect:/welcome";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model,String error,String logout) {
		if(error!=null)
			model.addAttribute("error","your username and password is invalid");
		if(logout!=null)
			model.addAttribute("message","You have been logged out successfully.");
		return "login";
	}
	
	@RequestMapping(value= "/welcome",method=RequestMethod.GET)
	public String welcome(Model model)
	{
		return "welcome";
	}

}
