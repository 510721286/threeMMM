/**
 * 
 */
package com.threeMMM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.threeMMM.model.UserEntity;
import com.threeMMM.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String add(UserEntity user) {
		userService.add(user);
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login(UserEntity user) {
		return "index";
	}
}
