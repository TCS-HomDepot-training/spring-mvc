package com.thd.training.controller;

import com.thd.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Autowired
	private UserService userService;

	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name="name", required=false, defaultValue="World") String name,
			Model model) {

		model.addAttribute("name", name);
		model.addAttribute("userList", userService.getAllUsers());

		return "greeting";
	}

}
