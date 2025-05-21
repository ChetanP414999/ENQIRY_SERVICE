package com.app.finanace.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	
	private int age;
	private String customerEmail;
	private long mobileNo;
	private String pancardNo;
	private String adharCard;
	private String password;
	private String gender;
	private String Enquirystatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibil;

	
	
	
	
}
