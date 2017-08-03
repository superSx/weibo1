package com.core.domin;

public class Follow {
	private Integer fmId;
	private Integer fansId;
	private Integer followId;
	private Integer groupId;
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getFollowId() {
		return followId;
	}
	public void setFollowId(Integer followId) {
		this.followId = followId;
	}
	public Integer getFansId() {
		return fansId;
	}
	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}
	public Integer getFmId() {
		return fmId;
	}
	public void setFmId(Integer fmId) {
		this.fmId = fmId;
	}
	@Override
	public String toString() {
		return "Follow [fmId=" + fmId + ", fansId=" + fansId + ", followId=" + followId + ", groupId=" + groupId + "]";
	}
}
