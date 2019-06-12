package com.comment.domain;

public class StuCourse {
	private String sid;
	private String cid;
	private String cname;
	private String teacher;
	private String credit;
	private String ctime;
	private String scores;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "StuCourse [sid=" + sid + ", cid=" + cid + ", cname=" + cname + ", teacher=" + teacher + ", credit="
				+ credit + ", ctime=" + ctime + ", scores=" + scores + "]";
	}
	
}
