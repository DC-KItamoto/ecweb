package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EcController {
	@RequestMapping("/index")
	public String top(Model model) {
		model.addAttribute("message", "Hello world");
		return "index";
	}

	@RequestMapping("/login")
	public String login(Users users, Model model) {
		model.addAttribute("login", "Login");
		return "login/input";
	}
}
