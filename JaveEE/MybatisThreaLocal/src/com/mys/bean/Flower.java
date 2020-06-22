package com.mys.bean;

public class Flower {
	private int id;
	private String name;
	private float price;
	private String producation;
	
	
	public Flower(int id, String name, float price, String producation) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.producation = producation;
	}
	public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProducation() {
		return producation;
	}
	public void setProducation(String producation) {
		this.producation = producation;
	}
	
}
