package com.rakuten.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rakuten.dto.User;

public class UserModel {
public boolean addUser(User user){
	boolean flag = false;
	
	String fullName = user.getFullName();
	String emailId = user.getEmailId();
	long contactNumber = user.getContactNumber();
	String password = user.getPassword();
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into user values(?, ?, ?, ?)");
		ps.setString(1, fullName);
		ps.setString(2, emailId);
		ps.setLong(3, contactNumber);
		ps.setString(4, password);
		int row = ps.executeUpdate();
		if(row>0){
			flag = true;
		}
		con.close();
		}
	catch(ClassNotFoundException cnfe){
		cnfe.printStackTrace();
	}
	catch(SQLException se){
		se.printStackTrace();
	}
	
	
	return flag;
}
}
