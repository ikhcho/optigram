package com.project.optigram.optibot.weather;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherService {
	private String query;
	private Document dom;
	private int type = 6;
	String selectDay;

	public WeatherService(String query){
		super();
		this.query = query;
		setDom();
	}

	private void setDom(){
		try{
			dom = Jsoup.connect("https://search.naver.com/search.naver?query=" + query).get();
	
			// 검색어 체크
			String[] oneDay = { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일", "내일" };
			String[] week = { "모레", "글피", "금주", "이번주", "다음주", "주말", "주간" };
			
			if (dom.select("div[class=w_now2]").hasText()) { 
				type = 1;
			} else if (dom.select("div[class=map _map_normal]").hasText()) { 
				type = 4;
			} else if(dom.select("div[class=map]").hasText()){
				type = 5;
			} else {
				for (String d : oneDay) {
					if (query.contains(d)) { 
						selectDay = d;
						type = 2;
					}
				}
				for (String d : week) { 
					if (query.contains(d)) { 
						type = 3;
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList NaverWeatherPaser() {
		String resultStr = "";
		Elements els;
		int mod = 0;
		ArrayList<WeatherVO> wvList = new ArrayList<WeatherVO>();
		ArrayList<WeekWeatherVO> wwvList = new ArrayList<WeekWeatherVO>();
		switch(type){
		case 1: // 1. 특정 위치 현재 날씨
			WeatherVO wvo = new WeatherVO();
			els = dom.select("div[class=w_now2]");
			for (Element e : els) {
				wvo.setTemperature(e.select("em").first().text().split("℃")[0]);
				wvo.setWeather(e.select("em").first().text().split("℃")[1]);
				wvo.setRainfall(e.select("strong[class=per_num]").first().text());
				wvo.setOzone(e.select("dd").select("strong").first().text());
				wvo.setDust(e.select("dt").select("strong").first().text());
				wvList.add(wvo);
			}
			return wvList;
		case 2: // 2. 특정 위치 미래 날씨
			els = dom.select("div[class=contents03_sub]");
			Elements dayEls = els.select("td");
			for (Element e : dayEls) {
				if (e.text().contains(selectDay)) {
					WeekWeatherVO wwv = new WeekWeatherVO();
					wwv.setLocation(e.select("dt[class=dat_time]").text());
					wwv.setWeather(e.select("p[class=dsc]").text());
					wwv.setTemperature(e.select("p[class^=temp]").select("em").first().text());
					if (e.select("p[class$=tp_max]").hasText())
						wwv.setTemperature2(e.select("p[class$=tp_max]").select("em").first().text());
					wwv.setRainfall(e.select("p[class=rain]").select("em").text());
					wwvList.add(wwv);
				}
			}
			break;
		case 3: // 3. 특정 위치 주간 날씨
			els = dom.select("div[class=contents03_sub]").select("td");
			for (Element e : els) {
				WeekWeatherVO wwv = new WeekWeatherVO();
				wwv.setLocation(e.select("dt[class=dat_time]").text());
				wwv.setWeather(e.select("p[class=dsc]").text());
				wwv.setTemperature(e.select("p[class^=temp]").select("em").first().text());
				if (e.select("p[class$=tp_max]").hasText())
					wwv.setTemperature2(e.select("p[class$=tp_max]").select("em").first().text());
				wwv.setRainfall(e.select("p[class=rain]").select("em").text());
				wwvList.add(wwv);
			}
			break;
		case 4: // 4. 위치 없는 현재 날씨
			els = dom.select("div[class=map _map_normal]").select("a");
			
			for (Element e : els) {
				WeekWeatherVO wwv = new WeekWeatherVO();
				if (mod % 2 == 0) {
					wwv = new WeekWeatherVO();
					wwv.setLocation(e.text());
				} else if (mod % 2 == 1) {
					wwv.setWeather(e.select("span[class^=state]").text());
					wwv.setTemperature(e.select("span[class=dsc]").text());
					wwvList.add(wwv);
				}
				mod++;
			}
			break;
		case 5: // 5. 위치 없는 주간 날씨
			els = dom.select("div[class=map]").select("a");
			WeekWeatherVO wwv = new WeekWeatherVO();
			for (Element e : els) {
				if (mod % 2 == 0) {
					wwv = new WeekWeatherVO();
					wwv.setLocation(e.text());
				} else if (mod % 2 == 1) {
					wwv.setWeather(e.select("span[class^=state]").text());
					wwv.setTemperature(e.select("span[class=dsc]").text());
					wwvList.add(wwv);
				}
				mod++;
			}
			break;
		}
		return wwvList;
	}

	public int getType() {
		return type;
	}
}
