package com.microlecture.bean;



public class PersonBean {
	private String name;		
	private String mail;		
	private String passWord;	
	private String account;		
	private String status;		//user type
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PersonBean [name=" + name + ", mail=" + mail + ", passWord="
				+ passWord + ", account=" + account + ", status=" + status
				+ "]";
	}
	
}
