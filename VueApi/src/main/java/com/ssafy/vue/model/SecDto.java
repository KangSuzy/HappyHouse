package com.ssafy.vue.model;

public class SecDto {
	private String userid;
	private String salt;
	private String seckey;
	
	
	public SecDto(String userid, String salt, String seckey) {
		super();
		this.userid = userid;
		this.salt = salt;
		this.seckey = seckey;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getSeckey() {
		return seckey;
	}
	public void setSeckey(String seckey) {
		this.seckey = seckey;
	}
	
	@Override
	public String toString() {
		return "SecDto [userid=" + userid + ", salt=" + salt + ", seckey=" + seckey + "]";
	}
	
	
}
