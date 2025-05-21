package com.app.finanace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.finanace.model.Cibil;
import com.app.finanace.service.CibilService;
import com.app.finanace.service.EnquiryService;

@RestController
public class CibilController {

	@Autowired
	private CibilService cibilService;
	
	@Autowired
	private EnquiryService enquiryService;
	
	
	@PatchMapping("/updatecibilbyid/{enquiryId}")
	public ResponseEntity<Cibil>onUpdate(@PathVariable("enquiryId")int enquiryId)
	{
			
		
		return null;
	}
	
	@GetMapping("/getcibilid/{cibilId}")
	public ResponseEntity<Cibil> findByCibilId(@PathVariable("cibilId") int cibilId){
		
		Cibil cibil=cibilService.findByCibilId(cibilId);
		
		return new ResponseEntity<Cibil>(cibil,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Cibil> onEnroll(@RequestBody Cibil cibil) {

		cibilService.saveCibil(cibil);

		return new ResponseEntity<Cibil>(cibil, org.springframework.http.HttpStatus.CREATED);
	}
	@GetMapping("/getAllCibil")
	public ResponseEntity<List<Cibil>> getAllcibil()
	{
		
		List<Cibil> cibil = cibilService.findAllCibil();
		return new ResponseEntity<List<Cibil>>(cibil,HttpStatus.OK);
		
		
	}
	
	
	
}
