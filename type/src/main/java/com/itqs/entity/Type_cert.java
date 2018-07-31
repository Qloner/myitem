package com.itqs.entity;

public class Type_cert {
	private int id;
	private int accttype;
	private int certid;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccttype() {
		return accttype;
	}

	public void setAccttype(int accttype) {
		this.accttype = accttype;
	}

	public int getCertid() {
		return certid;
	}

	public void setCertid(int certid) {
		this.certid = certid;
	}
	
	@Override
	public String toString() {
		return "Type_cert [id=" + id + ", accttype=" + accttype + ", certid="
				+ certid + "]";
	}
	
	public Type_cert(int id, int accttype, int certid) {
		super();
		this.id = id;
		this.accttype = accttype;
		this.certid = certid;
	}
	
	public Type_cert(int accttype, int certid) {
		super();
		this.accttype = accttype;
		this.certid = certid;
	}

	public Type_cert(){};
}
