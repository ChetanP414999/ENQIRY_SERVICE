package com.app.finanace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.finanace.model.Enquiry;
import com.app.finanace.service.EnquiryService;


@CrossOrigin("*")
@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;


	
	
	
	@PostMapping("/saveenquiry")
	public ResponseEntity<Enquiry> onEnqury(@RequestBody Enquiry e) {
		enquiryService.saveEnquiry(e);
		return new ResponseEntity<Enquiry>(e, HttpStatus.CREATED);
	}

	@GetMapping("/getenquirybyenquiryId/{customerID}")
	public ResponseEntity<Enquiry> onGeEnquiry(@PathVariable("customerID") int customerID) {
		Enquiry enquiry = enquiryService.findByCustomerID(customerID);
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	}

	@GetMapping("/getAllEnquiry")
	public ResponseEntity<List<Enquiry>> onGetAllEnquiry() {
		List<Enquiry> allEnquiries = enquiryService.findALL();
		return new ResponseEntity<List<Enquiry>>(allEnquiries, HttpStatus.OK);

	}
	
	@GetMapping("/forwordingtoOe/{customerId}")
	public ResponseEntity<Enquiry> forwordingtoOe(@PathVariable("customerId")int customerId)
	{
		
		Enquiry enquiry=enquiryService.forwardToOe(customerId);
//	e.setEnquirystatus(enquiry.getEnquirystatus());
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	}
	
	
	@GetMapping("/get_enquiry_byStatus/{enquirystatus}")
	public ResponseEntity<List<Enquiry>> getAllEnquiryByStatus(@PathVariable("enquirystatus")String enquirystatus)
	{
		List<Enquiry> enquiries=enquiryService.getEnquiryByStatus(enquirystatus);
		
		return new ResponseEntity<List<Enquiry>>(enquiries,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	@PutMapping("updateenquiry/{customerId}")
	public ResponseEntity<Enquiry>updateEnquiry(@PathVariable("customerId")int customerId,@RequestBody Enquiry enquiry)
	{
		Enquiry enquiry1=enquiryService.updateEnquiry(customerId,enquiry);
		return new ResponseEntity<Enquiry>(enquiry1,HttpStatus.CREATED);
		
	}
	
	
}
