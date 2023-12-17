package com.oaed.web.jdbc;

public class Student {
	private String studID;
	private String sName;
	private String fName;
	private String sMobile;
	private String sAddress;
	
	
	public Student(String studID, String sName, String fName, String sMobile, String sAddress) {
		
		this.studID = studID;
		this.sName = sName;
		this.fName = fName;
		this.sMobile = sMobile;
		this.sAddress = sAddress;
	}
	public Student(String sName, String fName, String sMobile, String sAddress) {
		
		this.sName = sName;
		this.fName = fName;
		this.sMobile = sMobile;
		this.sAddress = sAddress;
	}
	public String getStudID() {
		return studID;
	}
	public void setStudId(String studID) {
		this.studID = studID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getsMobile() {
		return sMobile;
	}
	public void setsMobile(String sMobile) {
		this.sMobile = sMobile;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	@Override
	public String toString() {
		return "Student [studID=" + studID + ", sName=" + sName + ", fName=" + fName + ", sMobile=" + sMobile
				+ ", sAddress=" + sAddress + "]";
	}
	
	
	


}
