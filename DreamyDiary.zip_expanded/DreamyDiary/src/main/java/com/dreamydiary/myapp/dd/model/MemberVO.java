package com.dreamydiary.myapp.dd.model;


public class MemberVO {
	private String userId;
	private String passWord;
	private String name;
	private String phoneNumber;
	private String email;
	private String birthDay;
	private String gender;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String eMail) {
		this.email = eMail;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemberVO [" + "userId=" + userId + ", passWord=" + passWord + ", name=" + name
				+ ", phoneNumber=" + phoneNumber + ", eMail=" + email + ", birthDay=" + birthDay + ", gender=" + gender
				+ "]";
	}
	
	
}
