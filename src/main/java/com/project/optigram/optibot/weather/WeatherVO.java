package com.project.optigram.optibot.weather;

import java.util.Arrays;

public class WeatherVO {
	private String temperature;
	private String weather;
	private String rainfall;
	private String ozone;
	private String dust;
	
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getRainfall() {
		return rainfall;
	}
	public void setRainfall(String rainfall) {
		this.rainfall = rainfall;
	}
	public String getOzone() {
		return ozone;
	}
	public void setOzone(String ozone) {
		this.ozone = ozone;
	}
	public String getDust() {
		return dust;
	}
	public void setDust(String dust) {
		this.dust = dust;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\"온도\" : \""+temperature+"\"");
		builder.append(", \"날씨\" : \""+weather+"\"");
		builder.append(", \"강수확률\" : \""+rainfall+"\"");
		builder.append(", \"오존\" : \""+ozone+"\"");
		builder.append(", \"미세먼지\" : \""+dust+"\"");
		return builder.toString();
	}
}
