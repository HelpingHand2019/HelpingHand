package com.capgemini.dto;

import com.capgemini.filter.CorsFilter;
import java.sql.Time;

import java.sql.Date;


public class HospitalDTO {
	private String hospitalId;
    private String hospitalName;
    private String hospitalEmail;
    private String hospitalPhoneNumber;
    private String hospitalAddress;
    private String registrationDate;
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalEmail() {
		return hospitalEmail;
	}
	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}
	public String getHospitalPhoneNumber() {
		return hospitalPhoneNumber;
	}
	public void setHospitalPhoneNumber(String hospitalPhoneNumber) {
		this.hospitalPhoneNumber = hospitalPhoneNumber;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "HospitalDTO [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalEmail="
				+ hospitalEmail + ", hospitalPhoneNumber=" + hospitalPhoneNumber + ", hospitalAddress="
				+ hospitalAddress + ", registrationDate=" + registrationDate + "]";
	}
	
    
    
}