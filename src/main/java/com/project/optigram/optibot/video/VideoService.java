package com.project.optigram.optibot.video;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.Iterator;

/**
 * Created by imgyucheol on 2017. 6. 3..
 */
public class VideoService {

    public String getKey(String searchKey) {
        String resultKey = null;
        if (searchKey == null) {
            // ?
            return "hi";
        }
        final String videoCode = "/watch?v=";
        String url = "https://www.youtube.com/results?search_query="+searchKey;

        try {
            Document doc = Jsoup.parse(new URL(url).openConnection().getInputStream(), "UTF-8", "https://www.youtube.com/");
        	
            Elements results = doc.select("#results").select("a");
            String alink = null;
            for(Element e : results){
            	if(e.attr("href").startsWith(videoCode)){
            		alink = e.attr("href");
            		break;
            	}
            }
            
            resultKey = alink.substring(alink.indexOf("=") + 1);
            resultKey = resultKey.contains("&")? resultKey.split("&")[0] : resultKey;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultKey;
    }

}
