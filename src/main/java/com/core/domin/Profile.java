package com.core.domin;

import java.sql.Timestamp;

public class Profile {
	private int profId;
	private int userId;
	private String profContent;
	private Timestamp profTime;
	private int tcId;
	private String ImageRef;
	private String publishName;
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public int getProfId() {
		return profId;
	}
	public void setProfId(int profId) {
		this.profId = profId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProfContent() {
		return profContent;
	}
	public void setProfContent(String profContent) {
		this.profContent = profContent;
	}
	@Override
	public String toString() {
		return "Profile [profId=" + profId + ", userId=" + userId + ", profContent=" + profContent + ", profTime="
				+ profTime + ", tcId=" + tcId + ", ImageRef=" + ImageRef + "]";
	}
	public Timestamp getProfTime() {
		return profTime;
	}
	public void setProfTime(Timestamp profTime) {
		this.profTime = profTime;
	}
	public int getTcId() {
		return tcId;
	}
	public void setTcId(int tcId) {
		this.tcId = tcId;
	}
	public String getImageRef() {
		return ImageRef;
	}
	public void setImageRef(String imageRef) {
		ImageRef = imageRef;
	}
}
