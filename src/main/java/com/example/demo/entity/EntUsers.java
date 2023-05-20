package com.example.demo.entity;

public class EntUsers {
	//daoに行き来する変数
	private String email;
	private String name;
	private String password;
	
	public EntUsers() {};
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
