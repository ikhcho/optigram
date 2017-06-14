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
	
	@RequestMapping(value = "/optibot", method = RequestMethod.GET)
	public String getBot() {
		return "optibot/bot";
	}
	
	@RequestMapping(value = "/optibot", method = RequestMethod.POST)
	public String postBot(String query) {
		String tag;
		tag = query.split(" ")[0];
		query = query.substring(query.indexOf(" ")+1).replace(" ", "+");
		
		if(tag.equals("/v") || tag.equals("/ㅍ") || tag.equals("/영상")){
			return "redirect:/optibot/video?query="+query;
		}else if(tag.equals("/f") || tag.equals("/ㄹ") || tag.equals("/음식")){
			return "redirect:/optibot/food?query="+query;
		}else if(tag.equals("/w") || tag.equals("/ㅈ") || tag.equals("/날씨")){
			query = query.contains("날씨")? query:query+"+날씨";
			return "redirect:/optibot/weather?query="+query;
		}
		return "optibot/bot";
	}
	
	@RequestMapping(value = "/optibot/v", method = RequestMethod.GET)
	public String videoBot(){
		return "optibot/video/optibot";
	}
	
	@ResponseBody
	@RequestMapping(value = "/video/search" )
	public String getVideoKey(@RequestParam("query") String query){
		VideoService vs = new VideoService();
		String key = vs.getKey(query);
		return key;
	}
	
	/*
	@RequestMapping(value = "/optibot/video", method = RequestMethod.GET)
	public ModelAndView video(@RequestParam("query") String query){
		ModelAndView mv = new ModelAndView();
		VideoService vs = new VideoService();
		String key = vs.getKey(query);

		mv.setViewName("optibot/video/optibot");
		mv.addObject("query", query);
		return mv;
	}
*/	
	@RequestMapping(value = "/optibot/food", method = RequestMethod.GET)
	public ModelAndView food(@RequestParam("query") String query){
		ModelAndView mv = new ModelAndView();
		FoodService fs = new FoodService();
		ArrayList<FoodVO> list = fs.DinningCodeParse(query);
		mv.setViewName("optibot/food/food");
		mv.addObject("flist", list);
		return mv;
	}
	
	@RequestMapping(value = "/optibot/weather", method = RequestMethod.GET)
	public ModelAndView weather(@RequestParam("query") String query){
		ModelAndView mv = new ModelAndView();
		WeatherService ws = new WeatherService(query);
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
