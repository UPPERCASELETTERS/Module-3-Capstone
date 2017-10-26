package com.techelevator.npgeek.model;

public class FormFiller {
	
	private String[] activityLevel = {"Inactive", "Sedentary", "Active", "Extremely active"};
	
	private String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD","MA", "MI", "MN", "MS", "MO", "MT",
			"NE","NV","NH","NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD","TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

	public String[] getActivityLevel() {
		return activityLevel;
	}

	public String[] getStates() {
		return states;
	}
	
	
}
