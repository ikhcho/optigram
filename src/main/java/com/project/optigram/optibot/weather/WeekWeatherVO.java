package com.project.optigram.optibot.weather;

import java.util.ArrayList;
import java.util.Arrays;

public class WeekWeatherVO {
	private String location;
	private String weather;
	private String temperature;
	private String temperature2;
	private String rainfall;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getTemperature2() {
		return temperature2;
	}
	public void setTemperature2(String temperature2) {
		this.temperature2 = temperature2;
	}
	public String getRainfall() {
		return rainfall;
	}
	public void setRainfall(String rainfall) {
		this.rainfall = rainfall;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\"요일(지역)\" : \""+location+"\"");
		builder.append(", \"날씨\" : \""+weather+"\"");
		builder.append(", \"최저온도(예상온도)\" : \""+temperature+"\"");
		builder.append(", \"최고온도\" : \""+temperature2+"\"");
		builder.append(", \"강수확률\" : \""+rainfall+"\"");
		return builder.toString();
	}
}
