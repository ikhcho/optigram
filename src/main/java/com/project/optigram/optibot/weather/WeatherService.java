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
	private WeatherVO wvo = new WeatherVO();
	WeekWeatherVO wwv = new WeekWeatherVO(new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
			new ArrayList<String>(), new ArrayList<String>());

	public WeatherService(String keyword){
		super();
		setQuery(keyword);
		setDom();
	}

	private void setQuery(String keyword) {
		String[] param;
		query = "";
		param = keyword.split(" ");
		for (String p : param) {
			query += p;
		}
	}

	private void setDom(){
		try{
			dom = Jsoup.connect("https://search.naver.com/search.naver?query=" + query).get();
	
			// �˻��� üũ
			String[] oneDay = { "������", "ȭ����", "������", "�����", "�ݿ���", "�����", "�Ͽ���", "����" };
			String[] week = { "��", "����", "����", "�̹���", "������", "�ָ�", "�ְ�" };
			
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
	
	public String Paser() {
		String resultStr = "";
		Elements els;
		int mod = 0;
		switch(type){
		case 1: // 1. Ư�� ��ġ ���� ����
			els = dom.select("div[class=w_now2]");
			for (Element e : els) {
				System.out.println(e.select("em").first().text());
				wvo.setTemperature(e.select("em").first().text().split("��")[0]);
				wvo.setWeather(e.select("em").first().text().split("��")[1]);
				wvo.setRainfall(e.select("strong[class=per_num]").first().text());
				wvo.setOzone(e.select("dd").select("strong").first().text());
				wvo.setDust(e.select("dt").select("strong").first().text());
			}
			break;
		case 2: // 2. Ư�� ��ġ �̷� ����
			els = dom.select("div[class=contents03_sub]");
			Elements dayEls = els.select("td");
			for (Element e : dayEls) {
				if (e.text().contains(selectDay)) {
					wwv.setLocation(e.select("dt[class=dat_time]").text());
					wwv.setWeather(e.select("p[class=dsc]").text());
					wwv.setTemperature(e.select("p[class^=temp]").select("em").first().text());
					if (e.select("p[class$=tp_max]").hasText())
						wwv.setTemperature2(e.select("p[class$=tp_max]").select("em").first().text());
					wwv.setRainfall(e.select("p[class=rain]").select("em").text());
				}
			}
			break;
		case 3: // 3. Ư�� ��ġ �ְ� ����
			els = dom.select("div[class=contents03_sub]").select("td");
			for (Element e : els) {
				wwv.setLocation(e.select("dt[class=dat_time]").text());
				wwv.setWeather(e.select("p[class=dsc]").text());
				wwv.setTemperature(e.select("p[class^=temp]").select("em").first().text());
				if (e.select("p[class$=tp_max]").hasText())
					wwv.setTemperature2(e.select("p[class$=tp_max]").select("em").first().text());
				wwv.setRainfall(e.select("p[class=rain]").select("em").text());
			}
			break;
		case 4: // 4. ��ġ ���� ���� ����
			els = dom.select("div[class=map _map_normal]").select("a");
			for (Element e : els) {
				if (mod % 2 == 0) {
					wwv.setLocation(e.text());
				} else if (mod % 2 == 1) {
					wwv.setWeather(e.select("span[class^=state]").text());
					wwv.setTemperature(e.select("span[class=dsc]").text());
				}
				mod++;
			}
			resultStr += "<br/><h1>Ư�� ������ �Է��ϸ� �� ��Ȯ�� ������ �� �� �ֽ��ϴ�.</h1>";
			break;
		case 5: // 5. ��ġ ���� �ְ� ����
			els = dom.select("div[class=map]").select("a");
			for (Element e : els) {
				if (mod % 2 == 0) {
					wwv.setLocation(e.text());
				} else if (mod % 2 == 1) {
					wwv.setWeather(e.select("span[class^=state]").text());
					wwv.setTemperature(e.select("span[class=dsc]").text());
				}
				mod++;
			}
			resultStr += "<br/><h1>Ư�� ������ �Է��ϸ� �� ��Ȯ�� ������ �� �� �ֽ��ϴ�.</h1>";
			break;
		}
		if (type != 1 && wwv.getLocation().size() == 0) {
			type = 6; // null
			resultStr += "<h1>�Է� ������ ã�� �� �����ϴ�.</h1>";
		}
		return resultStr;
	}

	public int getType() {
		return type;
	}

	public WeatherVO getWvo() {
		return wvo;
	}

	public WeekWeatherVO getWwv() {
		return wwv;
	}
}
