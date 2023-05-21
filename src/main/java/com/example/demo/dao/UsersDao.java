package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntUsers;

//SQLのUsersデータを操作する
@Repository
public class UsersDao {
	private final JdbcTemplate db;
	
	//@Autowiredは他のクラスをnewを使わずに宣言することができる
	@Autowired
	public UsersDao(JdbcTemplate db) {
		this.db = db;
	}
	
	//userがアカウント作成するさいに入力した値をSQLに送信する
	public void insertDb(EntUsers entuser) {
		String sql = "INSERT INTO USERS (email,name,password) VALUES (?,?,?)";
		db.update(sql,entuser.getEmail(),entuser.getName(),entuser.getPassword());
	}
	
	
}
