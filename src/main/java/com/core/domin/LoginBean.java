package com.core.domin;

public class LoginBean {
	private String loginName;
	private String assword;
	private int loginType;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getAssword() {
		return assword;
	}
	public void setAssword(String assword) {
		this.assword = assword;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	@Override
	public String toString() {
		return "”√ªß√˚:"+loginName+"\t√‹¬Î:"+assword+"!";
		
	}
	
}
