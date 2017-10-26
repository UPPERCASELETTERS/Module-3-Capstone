package com.techelevator.npgeek.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {
	
	@Autowired
	static ParkDao parkDao;
	
	@Autowired
	static SurveyDao surveyDao;
	
	public static boolean isEmailAvailable (String emailaddress){
		
		List<String> emails = surveyDao.getAllEmails();
		
		for(String email : emails) {
			if (emailaddress.equals(email)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidParkCode (String parkCode) {
		
		List<Park> parks = parkDao.getAllParks();
		for(Park park : parks) {
			if (parkCode.equals(park.getParkCode())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidActivity (String activity) {
		
		String[] activities = {"Inactive", "Sedentary", "Active", "Extremely active"};
		
		for (String act : activities) {
			if (act.equals(activity)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isAState (String maybeState){
		String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD","MA", "MI", "MN", "MS", "MO", "MT",
				"NE","NV","NH","NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD","TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
		
		for(String state : states){
			if(maybeState.equals(state)){
				return true;
			}
		}
		return false;
	}
}
