package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	//ログインした時にユーザー情報取得
	public List<EntUsers> loginUser(String pass, String email) {
		String sql = "SELECT * FROM USERS WHERE email = ? AND password = ? ";
		List<Map<String,Object>> resultDb1 = db.queryForList(sql,pass,email);
		List<EntUsers> resultDb2 = new ArrayList<EntUsers>();
		for(Map<String,Object> result:resultDb1) {
			EntUsers entuser = new EntUsers();
			entuser.setId((int)result.get("id"));
			entuser.setName((String)result.get("name"));
			entuser.setEmail((String)result.get("email"));
			entuser.setPassword((String)result.get("password"));
			resultDb2.add(entuser);
		}
		return resultDb2;
	}
	
	
}
