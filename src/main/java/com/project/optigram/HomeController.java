package com.project.optigram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/weather", method = RequestMethod.POST, produces = "application/json; charset=utf-8" )
	public ModelAndView weather(String input){
		ModelAndView mv = new ModelAndView();
		WeatherService ws = new WeatherService(input);
		String error = ws.Paser();
		switch(ws.getType()){
			case 1:
				mv.addObject("wvo",ws.getWvo());
				mv.setViewName("optibot/weather/one");
				break;
			case 4: case 5:
				mv.addObject("text",error);
			case 2: case 3:
				mv.addObject("wwv",ws.getWwv());
				mv.addObject("size",ws.getWwv().getLocation().size());
				mv.setViewName("optibot/weather/mul");
				break;
			case 6:
				mv.setViewName("optibot/weather/one");
				mv.addObject("text",error);
				break;
		}
		mv.addObject("type", ws.getType());
		return mv;
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
