package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Integer> getParkRanking() {

		String sqlParkRanking = "SELECT count(parkcode) AS count, parkcode FROM survey_result GROUP BY parkcode ORDER BY count DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkRanking);
		
		Map <String, Integer> parkCount = new HashMap<>();
		
		while(results.next()) {
	
			parkCount.put(results.getString("parkcode"), results.getInt("count"));
		}
		
		return parkCount;
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
