package com.core.domin;

public class RegistBean {
	private String loginName;
	private String password;
	private String nickName;
	private String trueName;
	private String Province;
	private String City;
	private String Sex;
	private String identifier;
	@Override
	public String toString() {
		return "RegistBean [loginName=" + loginName + ", password=" + password + ", nickName=" + nickName
				+ ", trueName=" + trueName + ", Province=" + Province + ", City=" + City + ", Sex=" + Sex
				+ ", identifier=" + identifier + "]";
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
