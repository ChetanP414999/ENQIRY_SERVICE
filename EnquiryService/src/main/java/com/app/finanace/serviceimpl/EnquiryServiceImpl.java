package com.app.finanace.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.finanace.enums.CibilEnums;

import com.app.finanace.exceptions.EnquiryObjectNotFoundException;
import com.app.finanace.model.Cibil;
import com.app.finanace.model.Enquiry;
import com.app.finanace.repository.EnquiryRepository;
import com.app.finanace.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryRepository;

	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	JavaMailSender sender;

	@Override
	public void saveEnquiry(Enquiry e) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(fromMail);
		mail.setTo(e.getCustomerEmail());
		
	String text =
	             "Dear"+ e.getCustomerName() +" "+"\n\n"
	            + "Thank you for reaching out to us. We’ve received your inquiry and our team is currently reviewing it. "
	            + "We will get back to you as soon as possible with more details or a solution to your request.\n\n"
	            + "If you have any additional information or questions, feel free to reply to this email or contact us directly at "
	           
	            + "We appreciate your interest in our services/products and look forward to assisting you!\n\n"
	            + "Best regards,\n"
	            + fromMail;
		
		mail.setText(text);
		mail.setSubject(" Thank You for Your Inquiry  – ");
		e.setEnquiryStatus("enquired");
		Cibil  cibil=new Cibil();
		cibil.setCibilScore(0);
		cibil.setCibilStatus(CibilEnums.POOR);
 		e.setCibil(cibil);
		enquiryRepository.save(e);
		//sender.send(mail);
	}

	@Override
	public Enquiry findByCustomerID(int customerID) {

		Enquiry enquiry = enquiryRepository.findBycustomerId(customerID);
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerID+ " Not Found");
		}
		else
		{
			return enquiry;	
		}
		
	}

	@Override
	public List<Enquiry> findALL() {

		return (List<Enquiry>) enquiryRepository.findAll();
	}

	@Override
	public Enquiry forwardToOe(int customerId) {
		
		
		Enquiry enquiry = enquiryRepository.findBycustomerId(customerId);
	
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerId+ " Not Found");
		}
		else
		{
			enquiry.setEnquiryStatus("forwardToOE");
			enquiryRepository.save(enquiry);
			return enquiry;
		}
		
		
		
	}

	@Override
	public Enquiry updateEnquiry(int customerId,Enquiry enquiry) {
		
		Enquiry enquiry2 = enquiryRepository.findBycustomerId(customerId);
		
		enquiry2.setCustomerName(enquiry.getCustomerName());
		enquiry2.setAdharCard(enquiry.getAdharCard());
		enquiry2.setCustomerAge(enquiry.getCustomerAge());
		enquiry2.setCustomerEmail(enquiry.getCustomerEmail());
		enquiry2.setGender(enquiry.getGender());
		enquiry2.setCustomerMobileNumber(enquiry.getCustomerMobileNumber());
		enquiry2.setEnquiryStatus(enquiry.getEnquiryStatus());
		enquiry2.setPassword(enquiry.getPassword());
		enquiry2.setCibil(enquiry.getCibil());
		enquiryRepository.save(enquiry2);
		return enquiry2;
	}

	@Override
	public List<Enquiry> getEnquiryByStatus(String enquirystatus) {
	
		
		List<Enquiry> list = enquiryRepository.findByEnquiryStatus(enquirystatus);
		
		
		
		return list;
	}

	
	

}
