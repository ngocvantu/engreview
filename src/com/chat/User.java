package com.chat;

import java.util.Random;

public class User {
	Random random = new Random();
	static final String[] colors = {"red", "blue", "green", "purple"};
	
	public User(String username) {
		this.username = username;
	}
	String username;
	String color = colors[random.nextInt(colors.length)];
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
