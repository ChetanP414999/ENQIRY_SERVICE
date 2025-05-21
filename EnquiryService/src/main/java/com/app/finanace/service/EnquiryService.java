package com.app.finanace.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.app.finanace.model.Enquiry;

public interface EnquiryService {

public 	void saveEnquiry(Enquiry e);

public Enquiry findByCustomerID(int customerID);

public List<Enquiry> findALL();
//
//public Enquiry updateCibilScore(int customerID);
//
//public Enquiry updateFirstName(String firstName,int customerID);
//
//public Enquiry updateLastName(String lastName,int customerID);
//
//public Enquiry updateEmail(String email,int customerID);
//
//public Enquiry updateMobileNo(long mobileNo,int customerID);

public Enquiry forwardToOe(int customerId);

public Enquiry updateEnquiry(int customerId, Enquiry enquiry);

public List<Enquiry> getEnquiryByStatus(String enquirystatus);

//List<Enquiry> searchByAnyField(@Param("value") String value);


}
