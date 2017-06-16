package com.project.optigram.optibot.food;

import java.util.Arrays;

public class FoodVO {
	private String title;
	private String location;
	private String[] menu;
	private String url;
	private String imgUrl;
	
	public FoodVO(String title, String location, String[] menu, String url, String imgUrl) {
		super();
		this.title = title;
		this.location = location;
		this.menu = menu;
		this.url = url;
		this.imgUrl = imgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String[] getMenu() {
		return menu;
	}
	public void setMenu(String[] menu) {
		this.menu = menu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\"이름\" : \""+title+"\"");
		builder.append(", \"imgUrl\" : \""+imgUrl+"\"");
		builder.append(", \"주소\" : \""+location+"\"");
		builder.append(", \"메뉴\" : \""+Arrays.toString(menu)+"\"");
		builder.append(", \"url\" : \""+url+"\"");
		return builder.toString();
	}
}