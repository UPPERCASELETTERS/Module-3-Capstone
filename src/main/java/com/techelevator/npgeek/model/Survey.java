package com.techelevator.npgeek.model;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private Long surveyId;
	
	@NotBlank (message="Please select a park code.")
	private String parkCode;
	
	@NotBlank (message="Email is required.") @Email (message="Please enter a valid email.")
	private String emailAddress;
	
	@NotBlank (message="Please select a state.")
	private String state;
	
	@NotBlank (message="Please select an activity level.")
	private String activityLevel;
	
	private boolean emailAvailable;
	@AssertTrue(message = "This email has already submitted a survey.")
	public boolean isEmailAvailable(){
		return Validator.isEmailAvailable(emailAddress);
	}
	
	private boolean validParkCode;
	@AssertTrue(message = "How did you enter an invalid park code?")
	public boolean isValidParkCode(){
		return Validator.isValidParkCode(parkCode);
	}
	
	private boolean validActivity;
	@AssertTrue(message = "Why do you do this?")
	public boolean isValidActivity(){
		return Validator.isValidActivity(activityLevel);
	}
	
	private boolean aState;
	@AssertTrue(message = "We had to write out every state code because of you.  Who hurt you?")
	public boolean isAState(){
		return Validator.isAState(state);
	}
	
	
	public Long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
}
