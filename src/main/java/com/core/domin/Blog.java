package com.core.domin;

import java.sql.Timestamp;

public class Blog {
	private Integer msgId;
	private Timestamp date;
	private Integer msgFrom;
	private Integer msgTo;
	private String msgContent;
	private Integer msgType;
	private Boolean msgRead;
	private String msgToName;
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public Integer getMsgTo() {
		return msgTo;
	}
	public void setMsgTo(Integer msgTo) {
		this.msgTo = msgTo;
	}
	public Integer getMsgFrom() {
		return msgFrom;
	}
	public void setMsgFrom(Integer msgFrom) {
		this.msgFrom = msgFrom;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	
	public Boolean getMsgRead() {
		return msgRead;
	}
	public void setMsgRead(Boolean msgRead) {
		this.msgRead = msgRead;
	}
	@Override
	public String toString() {
		return "Blog [msgId=" + msgId + ", date=" + date + ", msgFrom=" + msgFrom + ", msgTo=" + msgTo + ", msgContent="
				+ msgContent + ", msgType=" + msgType  + "]";
	}
	
	public String getMsgToName() {
		return msgToName;
	}
	public void setMsgToName(String msgToName) {
		this.msgToName = msgToName;
	}
	
}
