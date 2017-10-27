package com.techelevator.npgeek.model;

import java.util.List;
import java.util.Map;

public interface SurveyDao {
	
	public void saveSurvey (Survey survey);
	public List<SurveyResult> getParkRanking ();
	public List<String> getAllEmails (); 

}
