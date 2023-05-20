package com.example.demo;

//ユーザー情報
public class Users {
//viewで使える変数
	private String email;
	private String name;
	private String password;
	
	public Users() {};
	
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
