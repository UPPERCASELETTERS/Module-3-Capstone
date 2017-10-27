package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class SurveyJdbcDao implements SurveyDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SurveyJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveSurvey(Survey survey) {
		
		String sqlSaveSurvey = "INSERT INTO "
				+ "survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(
				sqlSaveSurvey, survey.getParkCode(), survey.getEmailAddress(),
				survey.getState(), survey.getActivityLevel()
				);
	}

	@Override
	public List<SurveyResult> getParkRanking() {

		String sqlParkRanking = "SELECT count(sr.parkcode) AS count, parkname FROM survey_result sr JOIN  park p ON sr.parkcode = p.parkcode GROUP BY sr.parkcode, p.parkname ORDER BY count DESC, p.parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkRanking);
		
		List <SurveyResult> surveyResults = new ArrayList<>();
		
		while(results.next()) {
			SurveyResult surveyResult = new SurveyResult();
			surveyResult.setParkName(results.getString("parkname"));
			surveyResult.setCount(results.getInt("count"));
			
			surveyResults.add(surveyResult);
		}
		
		return surveyResults;
	}

	@Override
	public List<String> getAllEmails() {
		
		String sqlGetAllEmails = "SELECT emailaddress FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmails);
		
		List<String> allEmails = new ArrayList<>();
		
		while(results.next()) {
			
			allEmails.add(results.getString("emailaddress"));	
		}
		return allEmails;	
	}

}
