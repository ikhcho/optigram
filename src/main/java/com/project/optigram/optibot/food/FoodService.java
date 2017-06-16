package com.project.optigram.optibot.food;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FoodService{
	public ArrayList DinningCodeParse(String query) {
		
		ArrayList<FoodVO> foodList = new ArrayList<FoodVO>();
		try {
			Document doc = Jsoup.connect("http://www.diningcode.com/isearch.php?query=" + query).get();
			Element info = doc.select(".container .search-row").get(0);//.select(".search-list-item-rn");
			//System.out.println("*** "+info.select(".search-title").text()+" ***");
			Elements infos = info.select(".search-list-item");
			for (Element e : infos) {
				String imgUrl = e.select(".search-list-item-img img").attr("src");
				String name = e.select(".search-list-item-rn").text();
				String href = e.select(".search-list-item-rn a").attr("href");
				if (href.length() < 1) continue;
				else href = "http://www.diningcode.com" + href;
				Document eachDoc = Jsoup.connect(href).get();
				String address = eachDoc.select(".item-container .item-information .item-information-text").get(2).text();// div.item-body-contents");
				Elements menus = eachDoc.select("#enc_item_area .rest-info-contents .rest-menu-block");
				
				//String avgPrice = eachDoc.select("#enc_item_area .rest-info-contents .rest-menu-right .time").get(0).text();// div.item-body-contents");
//				System.out.println(name);
//				System.out.println(address);
				String[] menuArray = null;
				if(menus.size() != 0){
					System.out.println("메뉴 정보");
					menuArray = new String[menus.size()];
					int i = 0;
					for(Element menu : menus){
						String menuName = menu.select(".rest-menu-left").text();
						String menuPrice = menu.select(".rest-menu-right").text();
						//System.out.println(menuName + "-" + menuPrice);
						menuArray[i] = menuName + "-" + menuPrice;
						i++;
					}
				}
				//System.out.println("URL : " + href);
				//System.out.println("Img URL : " + imgUrl);
				foodList.add(new FoodVO(name, address, menuArray, href, imgUrl));
			}
			System.out.println(foodList.toString());
			return foodList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

