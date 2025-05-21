package com.app.finanace.serviceimpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.finanace.model.Cibil;
import com.app.finanace.repository.CibilRepository;
import com.app.finanace.service.CibilService;

@Service
public class CibilServiceImpl  implements CibilService{

	@Autowired
	CibilRepository cibilRepository;
	
	
	
	public static int checkCibilScore() {
		Random random = new Random();
		int randomNumber = random.nextInt(601) + 300;
		return randomNumber;
	}
	
	
	@Override
	public void saveCibil(Cibil c) {

	}

	@Override
	public Cibil findByCibilId(int cibilId) {
		
		return cibilRepository.findByCibilId(cibilId);
	}


	@Override
	public List<Cibil> findAllCibil() {
		
		return cibilRepository.findAll();
	}
	

}
