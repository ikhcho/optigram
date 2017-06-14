package com.project.optigram.optibot.weather;

import java.util.ArrayList;

public class WeekWeatherVO {
	private ArrayList<String> location;
	private ArrayList<String> weather;
	private ArrayList<String> temperature;
	private ArrayList<String> temperature2;
	private ArrayList<String> rainfall;
	
	
	public WeekWeatherVO(ArrayList<String> location, ArrayList<String> weather, ArrayList<String> temperature, ArrayList<String> temperature2, ArrayList<String> rainfall) {
		super();
		this.location = location;
		this.weather = weather;
		this.temperature = temperature;
		this.temperature2 = temperature2;
		this.rainfall = rainfall;
	}
	public ArrayList<String> getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location.add(location);
	}
	public ArrayList<String> getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather.add(weather);
	}
	public ArrayList<String> getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature.add(temperature);
	}
	public ArrayList<String> getTemperature2() {
		return temperature2;
	}
	public void setTemperature2(String temperature2) {
		this.temperature2.add(temperature2);
	}
	public ArrayList<String> getRainfall() {
		return rainfall;
	}
	public void setRainfall(String rainfall) {
		this.rainfall.add(rainfall);
	}
}
