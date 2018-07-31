package com.itqs.entity;

public class T_cert {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "T_cert [id=" + id + ", name=" + name + "]";
	}
	public T_cert(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public T_cert(String name) {
		super();
		this.name = name;
	}
	
	public T_cert (){};
}
