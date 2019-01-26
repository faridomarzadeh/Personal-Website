package com.springmvc.website.validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.website.models.User;
import com.springmvc.website.services.IService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private IService<User> userService; 
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user=(User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length()<6|| user.getUsername().length()>32)
		{
			errors.rejectValue("username", "Size.userFrom.username");
			
		}
		if(userService.getByUsername(user.getUsername())!=null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if(user.getPassword().length()<8|| user.getPassword().length()>32)
		{
			errors.rejectValue("password", "Size.userForm.username");
		}
		if(!user.getPasswordConfirm().equals(user.getPassword()))
		{
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

}
