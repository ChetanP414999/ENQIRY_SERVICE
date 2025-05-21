package com.app.finanace.service;

import java.util.List;

import com.app.finanace.model.Cibil;

public interface CibilService {

	 public void saveCibil(Cibil c);

	public Cibil findByCibilId(int cibilId);

	public List<Cibil> findAllCibil();

}
