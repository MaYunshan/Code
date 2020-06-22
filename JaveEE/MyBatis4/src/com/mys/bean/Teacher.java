package com.mys.bean;

public class Teacher {
	private int id1;
	private String name1;
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	
	@Override
	public String toString() {
		return "Teacher [id1=" + id1 + ", name1=" + name1 + "]";
	}
	
}
