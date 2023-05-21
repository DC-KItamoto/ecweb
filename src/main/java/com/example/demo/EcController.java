package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.EntUsers;

@Controller
public class EcController {
	@RequestMapping("/index")
	public String top(Model model) {
		model.addAttribute("message", "Hello world");
		return "index";
	}

	@RequestMapping("/login")
	public String login(Users users, Model model) {
		model.addAttribute("login", "Eccom");
		return "login/input";
	}

	@RequestMapping("/confirm")
	public String confirm(Users user, Model model) {
		model.addAttribute("title", "Eccom");
		return "login/confirm";
	}

	// SampleDaoの用意
	private final UsersDao usersdao;

	@Autowired
	public EcController(UsersDao usersdao) {
		this.usersdao = usersdao;
	}

	@RequestMapping("/submit")
	public String submit(Users user, Model model) {
		model.addAttribute("message", "登録完了！");
		EntUsers entuser = new EntUsers();
		entuser.setName(user.getName());
		entuser.setEmail(user.getEmail());
		entuser.setPassword(user.getPassword());
		usersdao.insertDb(entuser);
		return "index";
	}

}
