package com.core.domin;

import java.sql.Timestamp;

public class User {
	private Integer userId;
	private String loginName;
	private String nickName;
	private String trueName;
	private String Province;
	private String City;
	private String Sex;
	private String Birthday;
	private String Email;
	private String QQ;
	private String intruduce;
	private String identifier;
	private Long schoolType;
	private String schoolName;
	private String college;
	private Long schoolTime;
	private String workProv;
	private String workCity;
	private String workplace;
	private Long workTimeTo;
	private Long workTimeFrom;
	private String department;
	private String tag;
	private Boolean comPower;
	private Boolean msgPower;
	private Boolean searchPower;
	private String blacklist;
	private String MSN;
	private String myFace;
	private Timestamp regTime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getIntruduce() {
		return intruduce;
	}
	public void setIntruduce(String intruduce) {
		this.intruduce = intruduce;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Long getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(Long schoolType) {
		this.schoolType = schoolType;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Long getSchoolTime() {
		return schoolTime;
	}
	public void setSchoolTime(Long schoolTime) {
		this.schoolTime = schoolTime;
	}
	public String getWorkProv() {
		return workProv;
	}
	public void setWorkProv(String workProv) {
		this.workProv = workProv;
	}
	public String getWorkCity() {
		return workCity;
	}
	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public Long getWorkTimeTo() {
		return workTimeTo;
	}
	public void setWorkTimeTo(Long workTimeTo) {
		this.workTimeTo = workTimeTo;
	}
	public Long getWorkTimeFrom() {
		return workTimeFrom;
	}
	public void setWorkTimeFrom(Long workTimeFrom) {
		this.workTimeFrom = workTimeFrom;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Boolean getComPower() {
		return comPower;
	}
	public void setComPower(Boolean comPower) {
		this.comPower = comPower;
	}
	public Boolean getMsgPower() {
		return msgPower;
	}
	public void setMsgPower(Boolean msgPower) {
		this.msgPower = msgPower;
	}
	public Boolean getSearchPower() {
		return searchPower;
	}
	public void setSearchPower(Boolean searchPower) {
		this.searchPower = searchPower;
	}
	public String getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}
	public String getMSN() {
		return MSN;
	}
	public void setMSN(String mSN) {
		MSN = mSN;
	}
	public String getMyFace() {
		return myFace;
	}
	public void setMyFace(String myFace) {
		this.myFace = myFace;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginName=" + loginName + ", nickName=" + nickName + ", trueName="
				+ trueName + ", Province=" + Province + ", City=" + City + ", Sex=" + Sex + ", Birthday=" + Birthday
				+ ", Email=" + Email + ", QQ=" + QQ + ", intruduce=" + intruduce + ", identifier=" + identifier
				+ ", schoolType=" + schoolType + ", schoolName=" + schoolName + ", college=" + college
				+ ", schoolTime=" + schoolTime + ", workProv=" + workProv + ", workCity=" + workCity + ", workplace="
				+ workplace + ", workTimeTo=" + workTimeTo + ", workTimeFrom=" + workTimeFrom + ", department="
				+ department + ", tag=" + tag + ", comPower=" + comPower + ", msgPower=" + msgPower + ", searchPower="
				+ searchPower + ", blacklist=" + blacklist + ", MSN=" + MSN + ", myFace=" + myFace + ", regTime="
				+ regTime + "]";
	}
	
	
}
