package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class ParkJdbcDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ParkJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
	
		List<Park> allParks = new ArrayList<>();
		
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		
		while(results.next()) {
			
			Park park = new Park();
			
			park.setParkCode(results.getString("parkcode"));
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setAcreage(results.getInt("acreage"));
			park.setElevationInFeet(results.getInt("elevationinfeet"));
			park.setMilesOfTrail(results.getDouble("milesoftrail"));
			park.setNumberOfCampsites(results.getInt("numberofcampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getInt("yearfounded"));
			park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			park.setInspirationalQuote(results.getString("inspirationalquote"));
			park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			park.setParkDescription(results.getString("parkdescription"));
			park.setEntryFee(results.getInt("entryfee"));
			park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
			
			allParks.add(park);
		}
		return allParks;
	}

	@Override
	public Park getParkByCode(String parkCode) {
		
		String sqlSelectPark = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPark, parkCode);
		
		results.next();
		
		Park park = new Park();
		
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationinfeet"));
		park.setMilesOfTrail(results.getDouble("milesoftrail"));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setInspirationalQuote(results.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		
		return park;
	}
}
