package com.itqs.entity;

public class Cert {
	private int cid;
	private String cname;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Cert [cid=" + cid + ", cname=" + cname + "]";
	}
	public Cert(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Cert(String cname) {
		super();
		this.cname = cname;
	}
	
	public Cert(){};
}
