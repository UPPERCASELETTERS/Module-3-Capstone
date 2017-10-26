package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class WeatherJdbcDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public WeatherJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeatherByParkCode (String parkCode){
		
		List<Weather> fivecast = new ArrayList<>();
		
		String sqlSelectAllWeather = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWeather, parkCode);
		
		 while(results.next()) {
			 
			 Weather weather = new Weather();
			 
			 weather.setParkCode(results.getString("parkcode"));
			 weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
			 weather.setLow(results.getInt("low"));
			 weather.setHigh(results.getInt("high"));
			 weather.setForecast(results.getString("forecast"));
			 
			 fivecast.add(weather);
		 }
		return fivecast;
	}
}
