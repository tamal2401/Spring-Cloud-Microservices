package com.java.clientservice1.model;

public class User {

	private String userName;
	private String mail;
	private int age;
	
	public User() {;
	}
	
	public User(String userName, String mail, int age) {
		super();
		this.userName = userName;
		this.mail = mail;
		this.age = age;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", mail=" + mail + ", age=" + age + "]";
	}
}
