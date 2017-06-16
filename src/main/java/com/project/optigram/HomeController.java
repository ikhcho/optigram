package com.project.optigram;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.optigram.optibot.food.FoodService;
import com.project.optigram.optibot.food.FoodVO;
import com.project.optigram.optibot.video.VideoService;
import com.project.optigram.optibot.weather.WeatherService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/optibot", method = RequestMethod.GET)
	public String getBot() {
		return "optibot/bot";
	}
	@ResponseBody
	@RequestMapping(value = "/optibot/video", method = RequestMethod.GET)
	public String getVideoKey(@RequestParam("query") String query){
		VideoService vs = new VideoService();
		String result = vs.getKey(query);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/optibot/food", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public String food(@RequestParam("query") String query){
		System.out.println(query);
		FoodService fs = new FoodService();
		ArrayList<FoodVO> list = fs.DinningCodeParse(query);
		String result = " {\"food\" : [";
		for(int i=0; i<list.size(); i++){
			result+="{";
			result += list.get(i).toString();
			result +="}";
			if(i != list.size()-1) result += ",";
		}
		result += "]}";
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/optibot/weather", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public String weather(@RequestParam("query") String query){
		WeatherService ws = new WeatherService(query);
		ArrayList list = ws.NaverWeatherPaser();
		String result = " {\"weather\" : [";
		if(ws.getType() ==1){
			result+="{";
			result += list.get(0).toString();
			result +="}";
		}else{
			for(int i=0; i<list.size(); i++){
				result+="{";
				result += list.get(i).toString();
				result +="}";
				if(i != list.size()-1) result += ",";
			}
		}
		result += "]}";
		System.out.println(result);
		return result;
	}
	
	
	
	@RequestMapping(value = "/game/ams", method = RequestMethod.GET)
	public String ams() {
		
		return "game/ams/version2/MS";
	}
	@RequestMapping(value = "/game/ams/version2/Rank", method = RequestMethod.GET)
	public String amsRank() {
		
		return "/game/ams/version2/Rank";
	}
	@RequestMapping(value = "/game/ams/version2/SaveData", method = RequestMethod.GET)
	public String amsSaveData() {
		
		return "/game/ams/version2/SaveData";
	}
}
