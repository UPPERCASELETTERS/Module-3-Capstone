package com.techelevator.npgeek.model;

public class Weather {
	
	private String parkCode;
	private Integer fiveDayForecastValue;
	private Integer low;
	private Integer high;
	private String forecast;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public Integer getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(Integer fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public Integer getLow() {
		return low;
	}
	public void setLow(Integer low) {
		this.low = low;
	}
	public Integer getHigh() {
		return high;
	}
	public void setHigh(Integer high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast.substring(0, 1).toUpperCase() + forecast.substring(1);
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getForecastImageURL() {
		if(forecast.equals("partly cloudy")){
			return "/img/weather/partlyCloudy.png";
		}
		return "/img/weather/" + forecast + ".png";
	}
	public boolean isTooHot () {
		return (high >= 75);
	}
	public boolean isTooCold () {
		return (low <= 20);
	}
	public boolean isVarying () {
		return (high-low >=20);
	}
	public String getRecommendation () {
		if(forecast.equals("snow")) {
			return "Pack snow shoes.";
		}
		if(forecast.equals("rain")) {
			return "Pack rain gear and waterproof shoes.";
		}
		if(forecast.equals("thunderstorms")) {
			return "Seek shelter and avoid hiking exposed ridges.";
		}
		if(forecast.equals("sunny")) {
			return "Pack sunscreen.";
		}
		return "Take a hike!";
	}
}
