package com.techelevator.npgeek;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.WeatherDao;

@Controller
public class ParkController {
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
		
	@RequestMapping(path = {"/","/home"}, method = RequestMethod.GET)
	public String getHome(ModelMap modelHolder) {
		
		modelHolder.put("parksList", parkDao.getAllParks());
		
		return "home";
	}
	@RequestMapping(path = {"/detail"}, method = RequestMethod.GET)
	public String getDetail(ModelMap modelHolder, @RequestParam String parkCode) {
		
		modelHolder.put("park", parkDao.getParkByCode(parkCode));
		
		modelHolder.put("fivecast", weatherDao.getWeatherByParkCode(parkCode));
		
		return "detail";
	}
	
	@RequestMapping(path = {"/detail"}, method = RequestMethod.POST)
	public String changeTemp(HttpSession session, @RequestParam String tempStyle, @RequestParam String parkCode) {
		System.out.println(tempStyle);
		session.setAttribute("tempStyle", tempStyle);
		
		return "redirect:/detail?parkCode="+parkCode;
	}
}
