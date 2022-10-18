package com.rakuten.dto;

import com.rakuten.exceptions.DataInValidException;

public class User {
private long contactNumber;
private String fullName;
private String emailId;
private String password;
public long getContactNumber() {
	return contactNumber;
}
public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	if(fullName.length()<3){
		throw new DataInValidException("Name should be greater than 3 latter");
	}
	this.fullName = fullName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	if(emailId.length()<5){
		throw new DataInValidException("Please enter your full email address");
	}
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	if(password.length()<8){
		throw new DataInValidException("Password should be 8 charater");
	}
	this.password = password;
}

}
