package com.yapp.utils;

public class Category {

	private String name;
	private int iconID;
	private boolean isFavorite;
	private int backgroundID;
	
	public Category(String name, int iconID, boolean isFavorite, int backgroundID) {
		super();
		this.name = name;
		this.iconID = iconID;
		this.isFavorite = isFavorite;
		this.backgroundID = backgroundID;
	}
	
	public String getName() {
		return name;
	}
	public int getIconID() {
		return iconID;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public int getBackgroundID() {
		return backgroundID;
	}
	
	public void toggleFavorite(){
		isFavorite = !isFavorite;
	}
}
