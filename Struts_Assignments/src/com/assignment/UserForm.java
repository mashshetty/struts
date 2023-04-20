package com.assignment;

import org.apache.struts.action.ActionForm;


public class UserForm extends ActionForm {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String fname,lname,dob,gender,city,state,adress1,adress2,email,emailnot;
private String uid,pincode;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getAdress1() {
	return adress1;
}
public void setAdress1(String adress1) {
	this.adress1 = adress1;
}
public String getAdress2() {
	return adress2;
}
public void setAdress2(String adress2) {
	this.adress2 = adress2;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEmailnot() {
	return emailnot;
}
public void setEmailnot(String emailnot) {
	this.emailnot = emailnot;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}

public void reset() {
	this.fname="";
	this.lname="";
	this.uid="";
	this.gender="";
	this.email="";
	this.emailnot="";
	this.adress1="";
	this.adress2="";
	this.city="";
	this.state="";
	this.pincode="";
	this.dob="";
	
}


public static long getSerialversionuid() {
	return serialVersionUID;
}



}
