package com.techelevator.npgeek;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.FormFiller;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.WeatherDao;


@Controller
public class ParkController {
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
	
	@Autowired
	SurveyDao surveyDao;
		
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
	
	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String getSurvey(ModelMap modelHolder){
		
		if(! modelHolder.containsAttribute("survey")){
			modelHolder.put("survey", new Survey());
		}
		
		modelHolder.put("parks", parkDao.getAllParks());
		modelHolder.put("formFiller", new FormFiller());
		
		return "survey";
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String postSurvey(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes flash){
		flash.addFlashAttribute("survey",survey);
		if(result.hasErrors()){
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"survey", result);
			return "redirect:/survey";
		}
		
		surveyDao.saveSurvey(survey);
		
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
	public String getFavoriteParks(ModelMap modelHolder){
		
		modelHolder.put("parkRanking", surveyDao.getParkRanking());
		
		
		return "favoriteParks";
	}
}
