package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.EntUsers;

@Controller
public class EcController {

	// SampleDaoの用意
	private final UsersDao usersdao;

	@Autowired
	public EcController(UsersDao usersdao) {
		this.usersdao = usersdao;
	}

	//userサインイン
	@RequestMapping("/index")
	public String top(Model model, Users user) {
		model.addAttribute("message", "Eccom");
		model.addAttribute("logMessa", "ログイン");
		return "index";
	}

	@RequestMapping("/top")
	public String sign(Users user, Model model) {
		if (user.getEmail() == "" || user.getPassword() == "") {
			model.addAttribute("message", "ログイン失敗");
			return "home/top";
		} else {
			model.addAttribute("message", "成功");
			model.addAttribute("logMessa", "成功");
			List<EntUsers> list = usersdao.loginUser(user.getEmail(), user.getPassword());
			model.addAttribute("user", list);
			return "home/top";
		}
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

	//user登録
	@RequestMapping("/submit")
	public String submit(Users user, Model model) {
		model.addAttribute("message", "Eccom");
		model.addAttribute("logMessa", "登録完了");
		EntUsers entuser = new EntUsers();
		entuser.setName(user.getName());
		entuser.setEmail(user.getEmail());
		entuser.setPassword(user.getPassword());
		usersdao.insertDb(entuser);
		return "index";
	}

}
