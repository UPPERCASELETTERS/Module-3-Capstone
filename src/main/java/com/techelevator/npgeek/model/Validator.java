package com.techelevator.npgeek.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired
	SurveyDao surveyDao;
	
	public boolean isEmailAvailable (String emailaddress){
		
		List<String> emails = surveyDao.getAllEmails();
		
		for(String email : emails) {
			if (emailaddress.equals(email)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValidParkCode (String parkcode) {
		
		List<Park> parks = parkDao.getAllParks();
		
		for(Park park : parks) {
			if (parkcode.equals(park.getParkCode())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isValidActivity (String activity) {
		
		String[] activities = {"inactive", "sedentary", "active", "extremely active"};
		
		for (String act : activities) {
			if (act.equals(activity)) {
				return true;
			}
		}
		return false;
	}
	
	
}
