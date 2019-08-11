package com.example.dataobjects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "userpersonaldetails")
public class UserPersonalDetails {

	@Id
	@GeneratedValue
	private Integer userId;
	
	@NotBlank (message = "First Name cannot be blank")
	private String firstName;
	
	private String lastName;
	
	@Email (message = "Please enter email in form of 'abc@mail.com'")
	private String emailId;
	
	//@Digits (fraction = 0 , integer = 10)
	//@Size (min = 10 , max = 10)
	private long mobileNo;
	
	@Enumerated (EnumType.STRING)
	private GenderEnum gender;
	
	@OneToOne
    @JoinColumn(name = "Id")
	@JsonIgnore
	private User user;
	
	
	
	public UserPersonalDetails() {}
	
	
	
	public UserPersonalDetails(Integer userId, @NotBlank(message = "First Name cannot be blank") String firstName,
			String lastName, @Email(message = "Please enter email in form of 'abc@mail.com'") String emailId,
			@Digits(fraction = 0, integer = 10) @Size(min = 10, max = 10) long mobileNo, GenderEnum gender,
			User user) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.user = user;
	}



	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "UserPersonalDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + "]";
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public GenderEnum getGender() {
		return gender;
	}



	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}





	
}
